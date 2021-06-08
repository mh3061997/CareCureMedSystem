package com.carecure.medsysten.controllers;

import com.carecure.medsysten.enums.EnumInventoryOrderType;
import com.carecure.medsysten.interfaces.ContIntInventoryOrder;
import com.carecure.medsysten.resources.ResInventoryOrder;
import com.carecure.medsysten.services.ServInventoryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
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
	public ResInventoryOrder addNewOrder(ResInventoryOrder newOrder) throws ParseException
	{

		if(newOrder.getType().equals(EnumInventoryOrderType.SUPPLY)) {
			return servInventoryOrder.addNewSupplyOrder(newOrder);
		} else if (newOrder.getType().equals(EnumInventoryOrderType.SELL)){
			return servInventoryOrder.addNewSellOrder(newOrder);
		}
		return null;
	}

	@Override
	public boolean reverseOrder(long code) throws ParseException
	{
		return servInventoryOrder.reverseOrder(code);
	}
}