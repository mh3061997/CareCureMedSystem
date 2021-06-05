package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.ResInventoryOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/inventory/order")
public interface ContIntInventoryOrder
{

	@RequestMapping(method = RequestMethod.GET)
	public List<ResInventoryOrder> getOrders(@RequestParam int pageNumber, @RequestParam int pageSize,
			@RequestParam String sortColumn, @RequestParam String sortDirection);

	@RequestMapping(method = RequestMethod.POST)
	public void addNewOrder(@RequestBody ResInventoryOrder newOrder);

	@RequestMapping(method = RequestMethod.DELETE, value = "/{code}")
	public void reverseOrder(@PathVariable("code") long code);
}
