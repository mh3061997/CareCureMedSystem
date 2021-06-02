package com.carecure.medsysten.services;

import com.carecure.medsysten.repositories.repoInventoryItem;
import com.carecure.medsysten.resources.resInventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class servInventoryItem
{
	@Autowired
	private repoInventoryItem repoInventoryItem;

	public List<resInventoryItem> getAllInventoryItems() {
		return StreamSupport.stream(repoInventoryItem.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	public void updateInventoryItemSellingPrice(long code,int updatedSellingPrice){
			repoInventoryItem.updateInventoryItemSellingPrice(code,updatedSellingPrice);
	}

}
