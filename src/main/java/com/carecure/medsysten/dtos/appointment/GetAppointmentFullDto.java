package com.carecure.medsysten.dtos.appointment;

import com.carecure.medsysten.dtos.doctor.GetDoctorSimpleDto;
import com.carecure.medsysten.dtos.patient.GetAllPatientDto;
import com.carecure.medsysten.enums.appointment.EnumAppointmentStatus;
import com.carecure.medsysten.enums.appointment.EnumAppointmentType;
import com.carecure.medsysten.enums.misc.EnumSpeciality;
import com.carecure.medsysten.resources.resNoteAppointment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GetAppointmentFullDto
{
	private long code;
	private EnumSpeciality speciality;
	private Date dateCreated;
	private Date dateToVisit;
	private EnumAppointmentStatus status;
	private EnumAppointmentType type;
	private String creationNote;
	private String userCreatedBy;
	private GetDoctorSimpleDto doctor;
	private GetAllPatientDto patient;
	private List<resNoteAppointment> doctorNotes;


}
