package com.carecure.medsysten.utils.mappers;

import com.carecure.medsysten.dtos.NewInventoryItemDto;
import com.carecure.medsysten.resources.resInventoryItem;

public class InventoryItemMapper
{

	public static resInventoryItem mapNewInventoryItemDtoToDao(NewInventoryItemDto newItemDto){
		resInventoryItem inventoryItemDao = new resInventoryItem();
		inventoryItemDao.setName(newItemDto.getName());
		inventoryItemDao.setSellingPrice(newItemDto.getSellingPrice());
		inventoryItemDao.setCategory(newItemDto.getCategory());
		return inventoryItemDao;
	}
}
