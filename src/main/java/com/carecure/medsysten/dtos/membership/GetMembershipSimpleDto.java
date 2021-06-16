package com.carecure.medsysten.dtos.membership;

import lombok.Data;

import java.util.Date;

@Data
public class GetMembershipSimpleDto
{
	private long code;
	private Date dateSubscriped;
	private long usedAmount;
	private long remainingAmount;
	private long patientCode;
	private String patientName;
	private long packageCode;
	private String packageName;

}
