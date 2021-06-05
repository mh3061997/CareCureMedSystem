
package com.carecure.medsysten.controllers;

import com.carecure.medsysten.dtos.NewInventoryItemDto;
import com.carecure.medsysten.interfaces.ContIntInventoryItem;
import com.carecure.medsysten.resources.ResInventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImplInventoryItem implements ContIntInventoryItem
{

	@Autowired
	com.carecure.medsysten.services.ServInventoryItem servInventoryItem;

	@Override
	public List<ResInventoryItem> getAllItems()
	{
		return servInventoryItem.getAllInventoryItems();
	}

	@Override
	public void updateInventoryItemSellingPrice(long code,int updatedSellingPrice)
	{
		servInventoryItem.updateInventoryItemSellingPrice(code,updatedSellingPrice);
	}

	@Override
	public void addNewInventoryItem(NewInventoryItemDto newItem){ servInventoryItem.addNewInventoryItem(newItem);}

}
