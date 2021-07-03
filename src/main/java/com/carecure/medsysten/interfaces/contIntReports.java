package com.carecure.medsysten.interfaces;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@RequestMapping("/reports")
@Api(tags = "Reports")
public interface contIntReports
{
	@RequestMapping(method = RequestMethod.GET,value = "")
	public HashMap getReports();
}
