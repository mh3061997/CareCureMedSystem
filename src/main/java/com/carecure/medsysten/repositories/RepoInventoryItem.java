package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.ResInventoryItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RepoInventoryItem extends CrudRepository<ResInventoryItem,Long>
{
	@Modifying
	@Transactional
	@Query("update ResInventoryItem item set item.sellingPrice = ?2 where item.code = ?1")
	void updateInventoryItemSellingPrice(long code, int newPrice);
}
