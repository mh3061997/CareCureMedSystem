package com.carecure.medsysten.controllers;

import com.carecure.medsysten.repositories.repoInventoryItem;
import com.carecure.medsysten.resources.resInventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class implInventoryItem
{

	@Autowired
	repoInventoryItem repo;


	@RequestMapping("/order")
	List<resInventoryItem> getAllItems() throws ParseException
	{
		resInventoryItem item = repo.findById(3L).get();
		Map<Date, Integer> map = item.getExpiryDates();
		map.put(new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), (int) Math.random());
		item.setExpiryDates(map);

		repo.save(item);


		return StreamSupport.stream(repo.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
}
