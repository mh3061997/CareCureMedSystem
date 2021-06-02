package com.carecure.medsysten.controllers;

import com.carecure.medsysten.dtos.NewInventoryItemDto;
import com.carecure.medsysten.interfaces.contIntInventoryItem;
import com.carecure.medsysten.resources.resInventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class implInventoryItem implements contIntInventoryItem
{

	@Autowired
	com.carecure.medsysten.services.servInventoryItem servInventoryItem;

	@Override
	public List<resInventoryItem> getAllItems()
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
