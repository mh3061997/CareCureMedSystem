package com.carecure.medsysten.services;

import com.carecure.medsysten.dtos.NewInventoryItemDto;
import com.carecure.medsysten.enums.EnumInventoryItemCategory;
import com.carecure.medsysten.projections.ProjInventoryItemNameAndCode;
import com.carecure.medsysten.repositories.RepoInventoryItem;
import com.carecure.medsysten.resources.ResInventoryItem;
import com.carecure.medsysten.utils.PaginationUtil;
import com.carecure.medsysten.utils.mappers.InventoryItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServInventoryItem
{
	private static final Logger logger = LoggerFactory.getLogger(ServInventoryItem.class.getName());

	@Autowired
	private RepoInventoryItem repoInventoryItem;

	public Page<ResInventoryItem> getItems(int pageNumber, int pageSize, String sortColumn, String sortDirection,
			EnumInventoryItemCategory category)
	{

		Pageable pageRequest =
				PaginationUtil.createPageRequest(ResInventoryItem.class, pageNumber, pageSize, sortColumn, sortDirection);
		if (category != null && !category.toString().isEmpty())
		{
			logger.info("Criteria by category : {}",category);
			return repoInventoryItem.findAllByCategory(category.toString(),pageRequest);
		}
		return repoInventoryItem.findAll(pageRequest);

	}

	public List<ProjInventoryItemNameAndCode> getItemsByCategoryLookup(EnumInventoryItemCategory category){
		return repoInventoryItem.findAllByCategoryLookup(category.toString());
	}
	public void updateInventoryItemSellingPrice(long code, int updatedSellingPrice)
	{
		repoInventoryItem.updateInventoryItemSellingPrice(code, updatedSellingPrice);
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
