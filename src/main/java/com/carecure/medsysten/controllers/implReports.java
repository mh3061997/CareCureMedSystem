package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntReports;
import com.carecure.medsysten.services.ServReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class implReports implements contIntReports
{
	@Autowired
	ServReports servReports;

	@Override
	public List<?> getMonthlySpecialitiesIncome()
	{
		return servReports.getMonthlySpecialityIncomeReport();
	}
}
