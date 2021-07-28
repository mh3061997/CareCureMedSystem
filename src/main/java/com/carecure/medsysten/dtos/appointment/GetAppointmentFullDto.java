package com.carecure.medsysten.dtos.appointment;

import com.carecure.medsysten.dtos.doctor.GetDoctorSimpleDto;
import com.carecure.medsysten.dtos.invoice.GetInvoiceSimpleDto;
import com.carecure.medsysten.dtos.patient.GetPatientSimpleDto;
import com.carecure.medsysten.resources.resNoteAppointment;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GetAppointmentFullDto
{
	private long code;
	private String speciality;
	private Date dateCreated;
	private Date dateToVisit;
	private String status;
	private String type;
	private String creationNote;
	private String userCreatedBy;
	private GetDoctorSimpleDto doctor;
	private GetPatientSimpleDto patient;
	private List<resNoteAppointment> doctorNotes;
	private String notes;
	private GetInvoiceSimpleDto invoice;
}
