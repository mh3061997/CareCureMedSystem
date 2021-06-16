package com.carecure.medsysten.dtos.inventory.order;

import com.carecure.medsysten.enums.Inventory.EnumInventoryOrderType;
import lombok.Data;

import java.util.Date;
@Data
public class NewInventoryOrderDto
{
	private int units;
	private int itemPrice;
	private int totalPrice;
	private Date itemExpiryDate;
	private Date orderDate;
	private String supplierName;
	private EnumInventoryOrderType type;
	private String userMadeBy;
	private long itemCode;
}
