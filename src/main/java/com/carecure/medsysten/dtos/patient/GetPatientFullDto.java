package com.carecure.medsysten.dtos.patient;

import com.carecure.medsysten.dtos.appointment.GetAppointmentSimpleDto;
import com.carecure.medsysten.dtos.invoice.GetInvoiceSimpleDto;
import com.carecure.medsysten.dtos.membership.GetMembershipSimpleDto;
import com.carecure.medsysten.resources.resMedImage;
import com.carecure.medsysten.security.models.UserDao;
import lombok.Data;

import java.util.List;

@Data
public class GetPatientFullDto
{
	private long code;
	private String name;
	private String gender;
	private String email;
	private String mobile;
	private int age;
	private long totalDebt;
	private String notes;
	List<GetInvoiceSimpleDto> invoiceMemberships;
	List<GetMembershipSimpleDto> memberships;
	List<GetAppointmentSimpleDto> appointments;
	List<resMedImage> medImages;
	private UserDao user;
}
