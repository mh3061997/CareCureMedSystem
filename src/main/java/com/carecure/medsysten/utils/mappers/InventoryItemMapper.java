package com.carecure.medsysten.utils.mappers;

import com.carecure.medsysten.dtos.NewInventoryItemDto;
import com.carecure.medsysten.resources.ResInventoryItem;

public class InventoryItemMapper
{

	public static ResInventoryItem mapNewInventoryItemDtoToDao(NewInventoryItemDto newItemDto){
		ResInventoryItem inventoryItemDao = new ResInventoryItem();
		inventoryItemDao.setName(newItemDto.getName());
		inventoryItemDao.setSellingPrice(newItemDto.getSellingPrice());
		inventoryItemDao.setCategory(newItemDto.getCategory());
		return inventoryItemDao;
	}
}
