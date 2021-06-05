package com.carecure.medsysten.services;

import com.carecure.medsysten.dtos.NewInventoryItemDto;
import com.carecure.medsysten.repositories.RepoInventoryItem;
import com.carecure.medsysten.resources.ResInventoryItem;
import com.carecure.medsysten.utils.mappers.InventoryItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ServInventoryItem
{
	@Autowired
	private RepoInventoryItem repoInventoryItem;

	public List<ResInventoryItem> getAllInventoryItems() {
		return StreamSupport.stream(repoInventoryItem.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	public void updateInventoryItemSellingPrice(long code,int updatedSellingPrice){
		repoInventoryItem.updateInventoryItemSellingPrice(code,updatedSellingPrice);
	}

	public void addNewInventoryItem(NewInventoryItemDto newItem)
	{
		repoInventoryItem.save(InventoryItemMapper.mapNewInventoryItemDtoToDao(newItem));
	}
}
