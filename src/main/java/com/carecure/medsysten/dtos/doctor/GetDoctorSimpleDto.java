package com.carecure.medsysten.dtos.doctor;

import com.carecure.medsysten.enums.misc.EnumGender;
import com.carecure.medsysten.enums.misc.EnumSpeciality;
import lombok.Data;

@Data
public class GetDoctorSimpleDto
{
	private long code;
	private String name;
	private String mobile;
	private String email;
	private EnumGender gender;
	private int age;
	private EnumSpeciality speciality;
	private int priceVisit;
	private int priceRevisit;
}
