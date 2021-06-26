package com.carecure.medsysten.dtos.appointment;

import lombok.Data;

import java.util.Date;

@Data
public class GetAppointmentSimpleDto
{
	private long code;
	private String speciality;
	private Date dateCreated;
	private Date dateToVisit;
	private String type;
	private String status;
	private String notes;
	private long patientCode;
	private String patientName;
	private long doctorCode;
	private String doctorName;
	private String userLoggerName;

}
