package com.carecure.medsysten.dtos.servicePriceList;

import com.carecure.medsysten.enums.misc.EnumSpeciality;
import lombok.Data;

@Data
public class NewServicePriceDto
{
	private String name;
	private int price;
	private EnumSpeciality speciality;
}
