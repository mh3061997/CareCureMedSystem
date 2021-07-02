package com.carecure.medsysten.services;

import com.carecure.medsysten.repositories.RepoReports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServReports
{
	@Autowired
	RepoReports repoReports;
	public List<?> getMonthlySpecialityIncomeReport(){
		return repoReports.getMonthSpecialitiesIncome();
	}
}
