package com.carecure.medsysten.dtos;

import com.carecure.medsysten.enums.enumInventoryItemCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NewInventoryItemDto
{
	private String name;
	private enumInventoryItemCategory category;
	private int sellingPrice;
}
