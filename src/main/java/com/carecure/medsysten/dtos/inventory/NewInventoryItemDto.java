package com.carecure.medsysten.dtos.inventory;

import com.carecure.medsysten.enums.enumInventoryItemCategory;
import lombok.Data;

@Data
public class NewInventoryItemDto
{
	private String name;
	private enumInventoryItemCategory category;
	private int sellingPrice;
}
