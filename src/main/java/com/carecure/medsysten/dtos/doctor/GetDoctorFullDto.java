package com.carecure.medsysten.dtos.doctor;

import com.carecure.medsysten.dtos.appointment.GetAppointmentSimpleDto;
import com.carecure.medsysten.enums.misc.EnumGender;
import com.carecure.medsysten.enums.misc.EnumSpeciality;
import com.carecure.medsysten.resources.resDoctorDayAvail;
import com.carecure.medsysten.security.models.UserDao;
import lombok.Data;

import java.util.List;

@Data
public class GetDoctorFullDto
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
	List<GetAppointmentSimpleDto> appointments;
	List<resDoctorDayAvail> availableDays;
	private UserDao user;

}
