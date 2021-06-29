package com.carecure.medsysten.dtos.packageBase;

import com.carecure.medsysten.enums.misc.EnumSpeciality;
import lombok.Data;

import java.util.Date;

@Data
public class NewPackageDto
{
	private String name;
	private Date dateExpired;
	private long price;
	private long unitTotal;
	private EnumSpeciality type;
}