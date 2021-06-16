package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.dtos.inventory.order.NewInventoryOrderDto;
import com.carecure.medsysten.resources.ResInventoryOrder;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RequestMapping("/inventory/order")
@Api(tags = "Inventory Order")
public interface ContIntInventoryOrder
{

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getOrders(@RequestParam int pageNumber, @RequestParam int pageSize,
			@RequestParam String sortColumn, @RequestParam String sortDirection);

	@RequestMapping(method = RequestMethod.POST)
	public ResInventoryOrder addNewOrder(@RequestBody NewInventoryOrderDto newOrder) throws ParseException;

	@RequestMapping(method = RequestMethod.DELETE, value = "/{code}")
	public boolean reverseOrder(@PathVariable("code") long code) throws ParseException;
}
