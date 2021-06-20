package com.carecure.medsysten.services;

import com.carecure.medsysten.dtos.NewInventoryOrderDto;
import com.carecure.medsysten.enums.EnumInventoryOrderType;
import com.carecure.medsysten.repositories.RepoInventoryItem;
import com.carecure.medsysten.repositories.RepoInventoryOrder;
import com.carecure.medsysten.resources.ResInventoryItem;
import com.carecure.medsysten.resources.ResInventoryOrder;
import com.carecure.medsysten.utils.PaginationUtil;
import com.carecure.medsysten.utils.mappers.InventoryOrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class ServInventoryOrder
{
	private static final Logger logger = LoggerFactory.getLogger(ServInventoryOrder.class.getName());

	@Autowired
	RepoInventoryOrder repoInventoryOrder;
	@Autowired
	RepoInventoryItem repoInventoryItem;

	public Page<ResInventoryOrder> getOrders(int pageNumber, int pageSize, String sortColumn, String sortDirection,
			EnumInventoryOrderType type, String startDate, String endDate)
	{

		Pageable pageRequest = PaginationUtil.createPageRequest(ResInventoryOrder.class,pageNumber, pageSize, sortColumn, sortDirection);

		if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty() && type != null && !type
				.toString().isEmpty())
		{
			if (startDate.equals(endDate))
			{
				logger.info("Criteria by type and on date, type:{}  on date {}", type, startDate);
				return repoInventoryOrder.findAllByTypeAndOrderDate(startDate, type.toString(), pageRequest);

			}
			logger.info("Criteria by date between  and type, type:{} , startDate: {} , endDate:{}", type, startDate,
					endDate);
			return repoInventoryOrder.findAllByTypeAndOrderDateBetween(startDate, endDate, type.toString(), pageRequest);
		}
		else if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty() && (type == null || type
				.toString().isEmpty()))
		{
			if (startDate.equals(endDate))
			{
				logger.info("Criteria by on date: {}", startDate);
				return repoInventoryOrder.findAllByOrderDate(startDate, pageRequest);
			}

			logger.info("Criteria by date between, startDate: {} , endDate:{}", startDate, endDate);
			return repoInventoryOrder.findAllByOrderDateBetween(startDate, endDate, pageRequest);

		}
		else if (type != null && !type.toString().isEmpty())
		{
			logger.info("Criteria by type, type:{}", type);

			return repoInventoryOrder.findAllByType(type.toString(), pageRequest);

		}

		logger.info("getting with no date or type criteria");
		return repoInventoryOrder.findAll(pageRequest);

	}

	public ResInventoryOrder addNewSupplyOrder(NewInventoryOrderDto newOrderDto) throws ParseException
	{
		//we can do this in one line as java passes primitives by value but objects be reference in memory
		//but if object copy is set to null original remains the same
		if (newOrderDto.getUnits() > 0)
		{
			Optional<ResInventoryItem> itemOptional = repoInventoryItem.findById(newOrderDto.getItemCode());
			if (itemOptional.isPresent() == false)
			{
				return null;
			}
			ResInventoryItem item = itemOptional.get();

			int availableUnits = item.getAvailableUnits();
			item.setAvailableUnits(availableUnits + newOrderDto.getUnits());
			item.addExpiryDateCount(newOrderDto.getOrderDate(), newOrderDto.getUnits());
			repoInventoryItem.save(item);
			return repoInventoryOrder.save(InventoryOrderMapper.mapNewInventoryOrderDtoToDao(newOrderDto));
		}
		return null;
	}

	public ResInventoryOrder addNewSellOrder(NewInventoryOrderDto newOrderDto) throws ParseException
	{
		Optional<ResInventoryItem> itemOptional = repoInventoryItem.findById(newOrderDto.getItemCode());
		if (itemOptional.isPresent() == false)
		{
			return null;
		}
		ResInventoryItem item = itemOptional.get();
		int availableUnits = item.getAvailableUnits();

		if (newOrderDto.getUnits() > availableUnits)
		{
			return null;
		}

		item.setAvailableUnits(availableUnits - newOrderDto.getUnits());
		item.deductExpiryDateCount(newOrderDto.getOrderDate(), newOrderDto.getUnits());
		repoInventoryItem.save(item);
		return repoInventoryOrder.save(InventoryOrderMapper.mapNewInventoryOrderDtoToDao(newOrderDto));

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
				logger.error("Available units less than reversal amount !");
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
		logger.error("Invalid order type could not reverse order");
		return false;
	}
}
