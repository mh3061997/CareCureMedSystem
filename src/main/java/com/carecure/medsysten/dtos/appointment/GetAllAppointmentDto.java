package com.carecure.medsysten.dtos.appointment;

import lombok.Data;

import java.util.Date;

@Data
public class GetAllAppointmentDto
{
	private long code;
	private String speciality;
	private Date dateCreated;
	private Date dateToVisit;
	private String type;
	private String notes;
	private String userLoggerName;
	private long patientCode;
	private String patientName;
	private String doctorName;

}
