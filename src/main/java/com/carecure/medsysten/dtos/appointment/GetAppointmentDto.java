package com.carecure.medsysten.dtos.appointment;

import com.carecure.medsysten.dtos.doctor.GetDoctorDto;
import com.carecure.medsysten.dtos.patient.GetPatientDto;
import com.carecure.medsysten.resources.resNoteAppointment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GetAppointmentDto
{
	private long code;
	private String speciality;
	private Date dateCreated;
	private Date dateToVisit;
	private String status;
	private String type;
	private String creationNote;
	private String userCreatedBy;
	private GetDoctorDto doctor;
	private GetPatientDto patient;
	private List<resNoteAppointment> doctorNotes;


}
