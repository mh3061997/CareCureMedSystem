package com.carecure.medsysten.dtos.appointment;

import com.carecure.medsysten.enums.appointment.EnumAppointmentStatus;
import com.carecure.medsysten.enums.appointment.EnumAppointmentType;
import com.carecure.medsysten.enums.misc.EnumSpeciality;
import lombok.Data;

import java.util.Date;

@Data
public class GetAppointmentSimpleDto
{
	private long code;
	private EnumSpeciality speciality;
	private Date dateCreated;
	private Date dateToVisit;
	private EnumAppointmentType type;
	private EnumAppointmentStatus status;
	private String notes;
	private String userLoggerName;
	private long patientCode;
	private String patientName;
	private String doctorName;

}
