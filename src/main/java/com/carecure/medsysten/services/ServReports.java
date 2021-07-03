package com.carecure.medsysten.services;

import com.carecure.medsysten.repositories.RepoReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ServReports
{
	@Autowired
	RepoReports repoReports;

	public List<?> getMonthlySpecialityIncomeReport()
	{
		return repoReports.getMonthSpecialitiesIncomeReport();
	}

	public List<?> getMonthlyInventoryInOut()
	{
		return repoReports.getMonthlyInventoryInOut();
	}

	public List<?> getMonthSpecialitiesCountReport()
	{
		return repoReports.getMonthSpecialitiesCountReport();
	}

	public List<?> getThisYearSpecialitiesPercentageCount()
	{
		return repoReports.getThisYearSpecialitiesPercentageCount();
	}

	public List<?> getThisYearSpecialitiesPercentageIncome()
	{
		return repoReports.getThisYearSpecialitiesPercentageIncome();
	}

	public HashMap getReports()
	{
		HashMap<String,List<?>> reportMap = new HashMap<>();
		reportMap.put("monthlySpecialitiesIncome",getMonthlySpecialityIncomeReport());
		reportMap.put("monthlySpecialitiesCount",getMonthSpecialitiesCountReport());
		reportMap.put("monthlyInventoryInOut",getMonthlyInventoryInOut());
		reportMap.put("yearSpecialitiesPercentageCount",getThisYearSpecialitiesPercentageCount());
		reportMap.put("yearSpecialitiesPercentageIncome",getThisYearSpecialitiesPercentageIncome());
		return reportMap;
	}
}
