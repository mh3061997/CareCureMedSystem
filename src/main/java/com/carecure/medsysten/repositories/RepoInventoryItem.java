package com.carecure.medsysten.repositories;

import com.carecure.medsysten.projections.ProjInventoryItemLookup;
import com.carecure.medsysten.resources.ResInventoryItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RepoInventoryItem extends PagingAndSortingRepository<ResInventoryItem,Long>
{
	@Modifying
	@Transactional
	@Query("update ResInventoryItem item set item.sellingPrice = ?2 where item.code = ?1")
	void updateInventoryItemSellingPrice(long code, int newPrice);

	@Query(value = "select * from ResInventoryItem item  where  item.category = ?1", nativeQuery = true)
	Page<ResInventoryItem> findAllByCategory(String category, Pageable pageable);

	@Query(value = "select name,code,sellingPrice,availableUnits from ResInventoryItem item  where  item.category = ?1", nativeQuery = true)
	List<ProjInventoryItemLookup> findAllByCategoryLookup(String category);

}
