package com.carecure.medsysten.dtos.appointment;

import com.carecure.medsysten.enums.appointment.EnumAppointmentType;
import com.carecure.medsysten.enums.misc.EnumSpeciality;
import lombok.Data;

import java.util.Date;

@Data
public class NewAppointmentDto
{

	private EnumSpeciality speciality;
	private Date dateCreated;
	private Date dateToVisit;
	private EnumAppointmentType type;
	private String creationNote;
	private String userCreatedBy;
	private long patientCode;
	private long doctorCode;
}
