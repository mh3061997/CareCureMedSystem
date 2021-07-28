package com.carecure.medsysten.dtos.invoice;

import com.carecure.medsysten.dtos.appointment.GetAppointmentSimpleDto;
import com.carecure.medsysten.dtos.membership.GetMembershipSimpleDto;
import com.carecure.medsysten.dtos.patient.GetPatientSimpleDto;
import com.carecure.medsysten.resources.resInvoiceItem;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GetInvoiceFullDto
{
	private long code;
	private Date dateCreated;
	private Date dateFinalized;
	private long totalDue;
	private long totalAfterDiscount;
	private long totalPaid;
	private long totalRemaining;
	private String status;
	private int discount;
	private String userFinalizedBy;
	private GetAppointmentSimpleDto appointment;
	private String paymentMethod;
	private List<resInvoiceItem> invoiceItems;
	private GetMembershipSimpleDto usedMembership;
	private GetPatientSimpleDto patientMembershipSubscriber;
}
