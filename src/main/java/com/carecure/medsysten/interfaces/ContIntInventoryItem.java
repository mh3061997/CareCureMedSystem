package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.dtos.inventory.item.NewInventoryItemDto;
import com.carecure.medsysten.enums.EnumInventoryItemCategory;
import com.carecure.medsysten.projections.ProjInventoryItemLookup;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/inventory/item")
@Api(tags = "Inventory Item")
public interface ContIntInventoryItem
{
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<?> getItems(@RequestParam int pageNumber, @RequestParam int pageSize, @RequestParam String sortColumn,
			@RequestParam String sortDirection, @RequestParam(required = false) EnumInventoryItemCategory category);

	@RequestMapping(method = RequestMethod.GET,value = "/lookup")
	List<ProjInventoryItemLookup> getItemsByCategoryLookup(@RequestParam EnumInventoryItemCategory category);

	@RequestMapping(method = RequestMethod.PUT)
	void updateInventoryItemSellingPrice(@RequestParam long code, @RequestParam int updatedSellingPrice);

	@RequestMapping(method = RequestMethod.POST, value = "")
	void addNewInventoryItem(@RequestBody NewInventoryItemDto newItem);
}
