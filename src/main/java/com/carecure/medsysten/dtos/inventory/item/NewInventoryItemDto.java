package com.carecure.medsysten.dtos.inventory.item;

import com.carecure.medsysten.enums.Inventory.enumInventoryItemCategory;
import lombok.Data;

@Data
public class NewInventoryItemDto
{
	private String name;
	private enumInventoryItemCategory category;
	private int sellingPrice;
}
