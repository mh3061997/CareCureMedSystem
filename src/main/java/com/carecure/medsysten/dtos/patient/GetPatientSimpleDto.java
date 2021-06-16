package com.carecure.medsysten.dtos.patient;

import com.carecure.medsysten.enums.misc.EnumGender;
import lombok.Data;

@Data
public class GetPatientSimpleDto
{
	private long code;
	private String name;
	private EnumGender gender;
	private String email;
	private String mobile;
	private int age;
	private long totalDebt;
	private String note;
}
