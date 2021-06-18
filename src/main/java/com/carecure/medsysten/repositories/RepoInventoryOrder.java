package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.ResInventoryOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RepoInventoryOrder extends PagingAndSortingRepository<ResInventoryOrder, Long>
{
	@Query(value = "select * from ResInventoryOrder ord  where  ord.type = ?3  AND  (ord.orderDate BETWEEN DATE(?1) AND DATE(?2))",
			nativeQuery = true)
	Page<ResInventoryOrder> findAllByTypeAndOrderDateBetween(String startDate, String endDate, String type,
			Pageable pageable);

	@Query(value = "select * from ResInventoryOrder ord  where  ord.type = ?1", nativeQuery = true)
	Page<ResInventoryOrder> findAllByType(String type, Pageable pageable);

	@Query(value = "select * from ResInventoryOrder ord  where (ord.orderDate BETWEEN DATE(?1) AND DATE(?2))",
			nativeQuery = true)
	List<ResInventoryOrder> findAllByOrderDateBetween(String startDate, String endDate, Pageable pageable);

}
