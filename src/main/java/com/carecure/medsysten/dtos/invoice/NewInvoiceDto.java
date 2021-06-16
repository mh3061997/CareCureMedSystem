package com.carecure.medsysten.dtos.invoice;

import com.carecure.medsysten.dtos.membership.GetMembershipSimpleDto;
import lombok.Data;

@Data
public class NewInvoiceDto
{
	private int discount;
	private long appointmentCode;
	private GetMembershipSimpleDto usedMembership;
}
