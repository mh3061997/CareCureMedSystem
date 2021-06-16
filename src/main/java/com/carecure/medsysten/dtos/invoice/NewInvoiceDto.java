package com.carecure.medsysten.dtos.invoice;

import com.carecure.medsysten.dtos.membership.GetMembershipSimpleDto;
import com.carecure.medsysten.enums.invoice.EnumInvoiceStatus;
import lombok.Data;

import java.util.Date;

@Data
public class NewInvoiceDto
{
	private Date dateCreated;
	private EnumInvoiceStatus status = EnumInvoiceStatus.NOTPAID;
	private int discount;
	private long appointmentCode;
	private GetMembershipSimpleDto usedMembership;
}
