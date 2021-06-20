package com.carecure.medsysten.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

public class PaginationUtil
{
	private static final Logger logger = LoggerFactory.getLogger(PaginationUtil.class.getName());

	public static PageRequest createPageRequest(Class objectClass,int pageNumber, int pageSize, String sortColumn, String sortDirection) {

		if (sortDirection == null)
		{
			sortDirection = "DESC";
		}
		Sort.Direction direction =
				sortDirection.equalsIgnoreCase("ASC") || sortDirection.equalsIgnoreCase("ASCENDING") ? Sort.Direction.ASC :
						Sort.Direction.DESC;

		String finalSortColumn = sortColumn;

		finalSortColumn = Arrays.stream(objectClass.getFields()).anyMatch(f -> f.getName().equals(sortColumn)) ?
				finalSortColumn : "code";

		logger.info(
				"Getting {} by Pagination using , PageNumber: {} , pageSize: {} , sortColumn: {} , sortDirection: {} ",
				objectClass.getName(),pageNumber, pageSize, finalSortColumn, direction);

		pageNumber = Math.max(pageNumber, 0);
		pageSize = Math.max(pageSize, 1);

		return  PageRequest.of(pageNumber, pageSize, Sort.by(direction, finalSortColumn));

	}

}
