package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.dtos.inventory.NewInventoryItemDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/inventory/item")
@Api(tags = "Inventory Item")
public interface ContIntInventoryItem
{
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<?> getItems(int pageNumber, int pageSize, String sortColumn, String sortDirection);

	@RequestMapping(method = RequestMethod.PUT,value = "/sellingPrice")
	void updateInventoryItemSellingPrice(@RequestParam long code, @RequestParam int updatedSellingPrice);

	@RequestMapping(method = RequestMethod.POST,value = "")
	void addNewInventoryItem( @RequestBody  NewInventoryItemDto newItem);
}
