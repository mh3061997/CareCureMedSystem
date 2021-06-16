package com.carecure.medsysten.dtos.invoice;

import com.carecure.medsysten.dtos.membership.GetMembershipSimpleDto;
import com.carecure.medsysten.enums.invoice.EnumInvoiceStatus;
import com.carecure.medsysten.enums.misc.EnumPaymentMethod;
import lombok.Data;

import java.util.Date;

@Data
public class GetInvoiceSimpleDto
{
	private long code;
	private Date dateCreated;
	private Date dateFinalized;
	private long totalPaid;
	private EnumInvoiceStatus status;
	private int discount;
	private String userFinalizedBy;
	private long appointmentCode;
	private EnumPaymentMethod paymentMethod;
	private GetMembershipSimpleDto usedMembership;
	private String patientName;
}
