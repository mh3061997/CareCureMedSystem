package com.carecure.medsysten.services;

import com.carecure.medsysten.dtos.inventory.item.NewInventoryItemDto;
import com.carecure.medsysten.repositories.RepoInventoryItem;
import com.carecure.medsysten.resources.ResInventoryItem;
import com.carecure.medsysten.utils.mappers.InventoryItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ServInventoryItem
{
	private static final Logger logger = LoggerFactory.getLogger(ServInventoryItem.class.getName());

	@Autowired
	private RepoInventoryItem repoInventoryItem;

	public List<ResInventoryItem> getItems(int pageNumber, int pageSize, String sortColumn, String sortDirection) {
		Sort.Direction direction =
				sortDirection.equalsIgnoreCase("ASC") || sortDirection.equalsIgnoreCase("ASCENDING") ? Sort.Direction.ASC :
						Sort.Direction.DESC;

		String finalSortColumn = sortColumn;

		finalSortColumn = Arrays.stream(ResInventoryItem.class.getFields()).anyMatch(f -> f.getName().equals(sortColumn)) ?
				finalSortColumn : "code";

		logger.info(
				"Getting Items by Pagination using , PageNumber: {} , pageSize: {} , sortColumn: {} , sortDirection: {} ",
				pageNumber, pageSize, finalSortColumn, direction);

		pageNumber = Math.max(pageNumber, 0);
		pageSize = Math.max(pageSize, 1);

		Pageable pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(direction, finalSortColumn));
		Iterable<ResInventoryItem> iterable = repoInventoryItem.findAll(pageRequest);

		return StreamSupport.stream(iterable.spliterator(), false)
				.collect(Collectors.toList());
	}

	public void updateInventoryItemSellingPrice(long code,int updatedSellingPrice){
		repoInventoryItem.updateInventoryItemSellingPrice(code,updatedSellingPrice);
	}

	public void addNewInventoryItem(NewInventoryItemDto newItem)
	{
		repoInventoryItem.save(InventoryItemMapper.mapNewInventoryItemDtoToDao(newItem));
	}

	public long getAllItemsCount()
	{
		long count = repoInventoryItem.count();
		logger.info("Getting Inventory Items count: {}", count);
		return count;
	}
}
