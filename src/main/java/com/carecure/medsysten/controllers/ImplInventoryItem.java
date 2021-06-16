
package com.carecure.medsysten.controllers;

import com.carecure.medsysten.dtos.inventory.item.NewInventoryItemDto;
import com.carecure.medsysten.interfaces.ContIntInventoryItem;
import com.carecure.medsysten.resources.ResInventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImplInventoryItem implements ContIntInventoryItem
{

	@Autowired
	com.carecure.medsysten.services.ServInventoryItem servInventoryItem;

	@Override
	public ResponseEntity<?> getItems(int pageNumber, int pageSize, String sortColumn, String sortDirection)
	{

		List<ResInventoryItem> items = servInventoryItem.getItems(pageNumber, pageSize, sortColumn, sortDirection);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("X-Total-Count",Long.toString(servInventoryItem.getAllItemsCount()));

		return ResponseEntity.ok().headers(responseHeaders).body(items);

	}

	@Override
	public void updateInventoryItemSellingPrice(long code,int updatedSellingPrice)
	{
		servInventoryItem.updateInventoryItemSellingPrice(code,updatedSellingPrice);
	}

	@Override
	public void addNewInventoryItem(NewInventoryItemDto newItem){ servInventoryItem.addNewInventoryItem(newItem);}

}
