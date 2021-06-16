package com.carecure.medsysten.dtos.packageBase;

import com.carecure.medsysten.enums.misc.EnumSpeciality;
import com.carecure.medsysten.enums.packageBase.EnumPackageBaseStatus;
import lombok.Data;

import java.util.Date;

@Data
public class GetPackageSimpleDto
{

	private long code;
	private String name;
	private Date dateCreated;
	private Date dateExpired;
	private EnumPackageBaseStatus status;
	private long price;
	private long unitTotal;
	private EnumSpeciality type;
}
