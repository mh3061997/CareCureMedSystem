package com.carecure.medsysten.utils.mappers;

import com.carecure.medsysten.dtos.inventory.order.NewInventoryOrderDto;
import com.carecure.medsysten.resources.ResInventoryItem;
import com.carecure.medsysten.resources.ResInventoryOrder;

public class InventoryOrderMapper
{
	public static ResInventoryOrder mapNewInventoryOrderDtoToDao(NewInventoryOrderDto orderDto){
		ResInventoryOrder orderDao = new ResInventoryOrder();
		ResInventoryItem itemDao = new ResInventoryItem();
		itemDao.setCode(orderDto.getItemCode());

		orderDao.setItem(itemDao);
		orderDao.setItemPrice(orderDto.getItemPrice());
		orderDao.setItemExpiryDate(orderDto.getItemExpiryDate());
		orderDao.setCancelled(false);
		orderDao.setOrderDate(orderDto.getOrderDate());
		orderDao.setSupplierName(orderDto.getSupplierName());
		orderDao.setTotalPrice(orderDto.getTotalPrice());
		orderDao.setType(orderDto.getType());
		orderDao.setUserMadeBy(orderDto.getUserMadeBy());
		orderDao.setUnits(orderDto.getUnits());
		orderDao.setNote(orderDto.getNote());
		return  orderDao;
	}
}
