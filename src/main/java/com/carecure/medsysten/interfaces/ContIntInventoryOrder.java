package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.dtos.NewInventoryOrderDto;
import com.carecure.medsysten.resources.ResInventoryOrder;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/inventory/order")
@Api(tags = "Inventory Order")
public interface ContIntInventoryOrder
{

	@RequestMapping(method = RequestMethod.GET)
	public List<ResInventoryOrder> getOrders(@RequestParam int pageNumber, @RequestParam int pageSize,
			@RequestParam String sortColumn, @RequestParam String sortDirection);

	@RequestMapping(method = RequestMethod.POST)
	public ResInventoryOrder addNewOrder(@RequestBody NewInventoryOrderDto newOrder) throws ParseException;

	@RequestMapping(method = RequestMethod.DELETE, value = "/{code}")
	public boolean reverseOrder(@PathVariable("code") long code) throws ParseException;
}
