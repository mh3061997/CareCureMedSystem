package com.carecure.medsysten.dtos.packageBase;

import com.carecure.medsysten.dtos.membership.GetMembershipSimpleDto;
import com.carecure.medsysten.enums.misc.EnumSpeciality;
import com.carecure.medsysten.enums.packageBase.EnumPackageBaseStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GetPackageFullDto
{
	private long code;
	private String name;
	private Date dateCreated;
	private Date dateExpired;
	private EnumPackageBaseStatus status;
	private long price;
	private long unitTotal;
	private EnumSpeciality type;
	private List<GetMembershipSimpleDto> memberships;
}
