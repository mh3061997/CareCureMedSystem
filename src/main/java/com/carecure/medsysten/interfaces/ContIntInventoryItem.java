package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.dtos.NewInventoryItemDto;
import com.carecure.medsysten.resources.ResInventoryItem;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/inventory/item")
public interface ContIntInventoryItem
{
	@RequestMapping(method = RequestMethod.GET)
	List<ResInventoryItem> getAllItems();

	@RequestMapping(method = RequestMethod.PUT,value = "/sellingPrice")
	void updateInventoryItemSellingPrice(@RequestParam long code, @RequestParam int updatedSellingPrice);

	@RequestMapping(method = RequestMethod.POST,value = "")
	void addNewInventoryItem( @RequestBody  NewInventoryItemDto newItem);
}
