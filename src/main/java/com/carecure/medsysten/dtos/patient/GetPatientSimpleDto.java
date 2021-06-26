package com.carecure.medsysten.dtos.patient;

import lombok.Data;

@Data
public class GetPatientSimpleDto
{
	private long code;
	private String name;
	private String gender;
	private String email;
	private String mobile;
	private int age;
	private long totalDebt;
	private String note;
}
