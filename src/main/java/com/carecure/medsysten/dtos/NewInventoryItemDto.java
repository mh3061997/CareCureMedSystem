package com.carecure.medsysten.dtos;

import com.carecure.medsysten.enums.EnumInventoryItemCategory;
import lombok.Data;

@Data
public class NewInventoryItemDto
{
	private String name;
	private EnumInventoryItemCategory category;
	private int sellingPrice;
}
