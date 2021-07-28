package com.carecure.medsysten.utils.mappers;

import com.carecure.medsysten.dtos.invoice.GetInvoiceFullDto;
import com.carecure.medsysten.dtos.invoice.GetInvoiceSimpleDto;
import com.carecure.medsysten.resources.resInvoice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceMapper
{
	@Autowired
	ModelMapper mapper;

	public GetInvoiceSimpleDto mapInvoiceDaoToSimpleDto(resInvoice dao)
	{
		return mapper.map(dao, GetInvoiceSimpleDto.class);
	}

	public List<GetInvoiceSimpleDto> mapInvoiceDaoToSimpleDto(List<resInvoice> daoList)
	{
		List<GetInvoiceSimpleDto> dtoList = new ArrayList<>();
		daoList.forEach(dao -> dtoList.add(mapInvoiceDaoToSimpleDto(dao)));
		return dtoList;
	}

	public GetInvoiceFullDto mapInvoiceDaoToFullDto(resInvoice dao)
	{
		return mapper.map(dao, GetInvoiceFullDto.class);
	}
}
