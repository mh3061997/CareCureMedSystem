package com.carecure.medsysten.dtos.invoice;

import lombok.Data;

import java.util.Date;

@Data
public class GetInvoiceSimpleDto
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
	private long appointmentCode;
	private String paymentMethod;
	private String patientName;
}
