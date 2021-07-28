package com.carecure.medsysten.dtos.doctor;

import lombok.Data;

@Data
public class GetDoctorSimpleDto
{
	private long code;
	private String name;
	private String mobile;
	private String email;
	private String gender;
	private int age;
	private String speciality;
	private int priceVisit;
	private int priceRevisit;
}
