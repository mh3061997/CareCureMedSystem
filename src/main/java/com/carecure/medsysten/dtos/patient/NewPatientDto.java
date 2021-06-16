package com.carecure.medsysten.dtos.patient;

import com.carecure.medsysten.enums.misc.EnumGender;
import lombok.Data;

@Data
public class NewPatientDto
{
	private String name;
	private EnumGender gender;
	private String email;
	private String mobile;
	private int age;
	private String note;
}
