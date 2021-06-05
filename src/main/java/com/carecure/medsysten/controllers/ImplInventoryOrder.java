package com.carecure.medsysten.controllers;

import com.carecure.medsysten.enums.EnumInventoryOrderType;
import com.carecure.medsysten.interfaces.ContIntInventoryOrder;
import com.carecure.medsysten.resources.ResInventoryOrder;
import com.carecure.medsysten.services.ServInventoryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImplInventoryOrder implements ContIntInventoryOrder
{

	@Autowired
	ServInventoryOrder servInventoryOrder;

	@Override
	public List<ResInventoryOrder> getOrders(int pageNumber, int pageSize, String sortColumn, String sortDirection)
	{
		return servInventoryOrder.getOrders(pageNumber, pageSize, sortColumn, sortDirection);
	}

	@Override
	public void addNewOrder(ResInventoryOrder newOrder)
	{

		if(newOrder.getType().equals(EnumInventoryOrderType.SUPPLY)) {
			servInventoryOrder.addNewSupplyOrder(newOrder);
		} else if (newOrder.getType().equals(EnumInventoryOrderType.SELL)){
			servInventoryOrder.addNewSellOrder(newOrder);
		}

	}

	@Override
	public void reverseOrder(long code)
	{

	}
}
