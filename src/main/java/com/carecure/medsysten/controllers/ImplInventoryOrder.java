package com.carecure.medsysten.controllers;

import com.carecure.medsysten.dtos.NewInventoryOrderDto;
import com.carecure.medsysten.enums.EnumInventoryOrderType;
import com.carecure.medsysten.interfaces.ContIntInventoryOrder;
import com.carecure.medsysten.resources.ResInventoryOrder;
import com.carecure.medsysten.services.ServInventoryOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class ImplInventoryOrder implements ContIntInventoryOrder
{
	private static final Logger logger = LoggerFactory.getLogger(ImplInventoryOrder.class.getName());

	@Autowired
	ServInventoryOrder servInventoryOrder;

	@Override
	public ResponseEntity<?> getOrders(int pageNumber, int pageSize, String sortColumn, String sortDirection,
			EnumInventoryOrderType type, String startDate, String endDate)
	{
		Page<ResInventoryOrder> ordersPage =
				servInventoryOrder.getOrders(pageNumber, pageSize, sortColumn, sortDirection, type, startDate, endDate);
		logger.info("Retrieved Page : {}",ordersPage);
		HttpHeaders responseHeaders = new HttpHeaders();
		long totalCount = ordersPage.getTotalElements();
		logger.info("Setting X-Total-Count Header to {}",totalCount);
		responseHeaders.set("X-Total-Count", Long.toString(totalCount));
		return ResponseEntity.ok().headers(responseHeaders).body(ordersPage.getContent());

	}

	@Override
	public ResInventoryOrder addNewOrder(NewInventoryOrderDto newOrder) throws ParseException
	{

		if (newOrder.getType().equals(EnumInventoryOrderType.SUPPLY))
		{
			return servInventoryOrder.addNewSupplyOrder(newOrder);
		}
		else if (newOrder.getType().equals(EnumInventoryOrderType.SELL))
		{
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
