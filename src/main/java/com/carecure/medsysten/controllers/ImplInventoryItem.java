package com.carecure.medsysten.controllers;

import com.carecure.medsysten.dtos.NewInventoryItemDto;
import com.carecure.medsysten.enums.EnumInventoryItemCategory;
import com.carecure.medsysten.interfaces.ContIntInventoryItem;
import com.carecure.medsysten.resources.ResInventoryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImplInventoryItem implements ContIntInventoryItem
{
	private static final Logger logger = LoggerFactory.getLogger(ImplInventoryItem.class.getName());

	@Autowired
	com.carecure.medsysten.services.ServInventoryItem servInventoryItem;

	@Override
	public ResponseEntity<?> getItems(int pageNumber, int pageSize, String sortColumn, String sortDirection,
			EnumInventoryItemCategory category)
	{

		Page<ResInventoryItem> itemsPage =
				servInventoryItem.getItems(pageNumber, pageSize, sortColumn, sortDirection, category);
		logger.info("Retrieved Page : {}", itemsPage);
		HttpHeaders responseHeaders = new HttpHeaders();
		long totalCount = itemsPage.getTotalElements();
		logger.info("Setting X-Total-Count Header to {}", totalCount);
		responseHeaders.set("X-Total-Count", Long.toString(totalCount));
		return ResponseEntity.ok().headers(responseHeaders).body(itemsPage.getContent());
	}

	@Override
	public void updateInventoryItemSellingPrice(long code, int updatedSellingPrice)
	{
		servInventoryItem.updateInventoryItemSellingPrice(code, updatedSellingPrice);
	}

	@Override
	public void addNewInventoryItem(NewInventoryItemDto newItem)
	{
		servInventoryItem.addNewInventoryItem(newItem);
	}

}
