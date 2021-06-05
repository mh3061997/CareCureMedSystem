package com.carecure.medsysten.services;

import com.carecure.medsysten.repositories.RepoInventoryOrder;
import com.carecure.medsysten.resources.ResInventoryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ServInventoryOrder
{
	@Autowired
	RepoInventoryOrder repoInventoryOrder;

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

	public void addNewSupplyOrder(ResInventoryOrder newOrder)
	{
		//we can do this in one line as java passes primitives by value but objects be reference in memory
		//but if object copy is set to null original remains the same
		newOrder.getItem().setAvailableUnits(3245);
		repoInventoryOrder.save(newOrder);
	}

	public boolean addNewSellOrder(ResInventoryOrder newOrder)
	{
		if (newOrder.getUnits() < newOrder.getItem().getAvailableUnits())
		{
			return false;
		}

		newOrder.getItem().setName("safsdf");
		repoInventoryOrder.save(newOrder);
		return true;
	}

	public boolean reverseOrder(ResInventoryOrder newOrder)
	{
		return false;
	}
}
