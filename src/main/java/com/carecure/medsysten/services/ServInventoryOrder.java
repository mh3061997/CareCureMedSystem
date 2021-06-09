package com.carecure.medsysten.services;

import com.carecure.medsysten.enums.EnumInventoryOrderType;
import com.carecure.medsysten.repositories.RepoInventoryItem;
import com.carecure.medsysten.repositories.RepoInventoryOrder;
import com.carecure.medsysten.resources.ResInventoryItem;
import com.carecure.medsysten.resources.ResInventoryOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ServInventoryOrder
{
	@Autowired
	RepoInventoryOrder repoInventoryOrder;
	@Autowired
	RepoInventoryItem repoInventoryItem;

	private static final Logger LOGGER = LoggerFactory.getLogger(ServInventoryOrder.class.getName());

	public List<ResInventoryOrder> getOrders(int pageNumber, int pageSize, String sortColumn, String sortDirection)
	{
		Sort.Direction direction =
				sortDirection.equalsIgnoreCase("ASC") || sortDirection.equalsIgnoreCase("ASCENDING") ? Sort.Direction.ASC :
						Sort.Direction.DESC;
		pageNumber = pageNumber >= 0 ? pageNumber : 0;
		pageSize = pageSize >= 1 ? pageSize : 1;
		Pageable pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(direction, sortColumn));
		Iterable<ResInventoryOrder> iterable = repoInventoryOrder.findAll(pageRequest);
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}

	public ResInventoryOrder addNewSupplyOrder(ResInventoryOrder newOrder) throws ParseException
	{
		//we can do this in one line as java passes primitives by value but objects be reference in memory
		//but if object copy is set to null original remains the same
		if (newOrder.getUnits() > 0)
		{
			Optional<ResInventoryItem> itemOptional = repoInventoryItem.findById(newOrder.getItem().getCode());
			if (itemOptional.isPresent() == false)
			{
				return null;
			}
			ResInventoryItem item = itemOptional.get();

			int availableUnits = item.getAvailableUnits();
			item.setAvailableUnits(availableUnits + newOrder.getUnits());
			item.addExpiryDateCount(newOrder.getOrderDate(), newOrder.getUnits());
			newOrder.setItem(item);
			repoInventoryItem.save(item);
			return repoInventoryOrder.save(newOrder);
		}
		return null;
	}

	public ResInventoryOrder addNewSellOrder(ResInventoryOrder newOrder) throws ParseException
	{
		Optional<ResInventoryItem> itemOptional = repoInventoryItem.findById(newOrder.getItem().getCode());
		if (itemOptional.isPresent() == false)
		{
			return null;
		}
		ResInventoryItem item = itemOptional.get();
		int availableUnits = item.getAvailableUnits();

		if (newOrder.getUnits() > availableUnits)
		{
			return null;
		}

		item.setAvailableUnits(availableUnits - newOrder.getUnits());
		item.deductExpiryDateCount(newOrder.getOrderDate(), newOrder.getUnits());
		newOrder.setItem(item);
		repoInventoryItem.save(item);
		return repoInventoryOrder.save(newOrder);

	}

	public boolean reverseOrder(long code) throws ParseException
	{
		Optional<ResInventoryOrder> orderOptional = repoInventoryOrder.findById(code);
		if (orderOptional.isPresent() == false)
		{
			return false;
		}
		ResInventoryOrder order = orderOptional.get();

		if (order.getType().equals(EnumInventoryOrderType.SUPPLY))
		{
			ResInventoryItem item = order.getItem();

			int availableUnits = item.getAvailableUnits();

			if (order.getUnits() > availableUnits)
			{
				LOGGER.error("Available units less than reversal amount !");
				return false;
			}

			item.setAvailableUnits(availableUnits - order.getUnits());
			item.deductExpiryDateCount(order.getOrderDate(), order.getUnits());
			order.setCancelled(true);
			repoInventoryOrder.save(order);
			repoInventoryItem.save(item);
			return true;
		}
		else if (order.getType().equals(EnumInventoryOrderType.SELL))
		{
			ResInventoryItem item = order.getItem();
			item.setAvailableUnits(item.getAvailableUnits() + order.getUnits());
			item.addExpiryDateCount(order.getOrderDate(), order.getUnits());
			order.setCancelled(true);
			repoInventoryOrder.save(order);
			repoInventoryItem.save(item);
			return true;
		}
		LOGGER.error("Invalid order type could not reverse order");
		return false;
	}
}
