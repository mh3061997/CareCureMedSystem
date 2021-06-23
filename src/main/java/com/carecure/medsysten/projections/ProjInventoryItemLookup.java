package com.carecure.medsysten.projections;

public interface ProjInventoryItemLookup
{
	Long getCode();
	String getName();
	int getSellingPrice();
	int getAvailableUnits();
}
