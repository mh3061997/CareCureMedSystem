package com.carecure.medsysten.mapper;

import com.carecure.medsysten.dtos.invoice.GetInvoiceFullDto;
import com.carecure.medsysten.dtos.invoice.GetInvoiceSimpleDto;
import com.carecure.medsysten.resources.resInvoice;
import com.carecure.medsysten.utils.mappers.InvoiceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.carecure.medsysten.testUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class InvoiceMapperTests
{
	@Autowired
	com.carecure.medsysten.services.servInvoice servInvoice;
	@Autowired
	InvoiceMapper mapper;

	@Test
	void assertInvoiceDaoEqualsSimpleDto()
	{
		resInvoice dao = servInvoice.getInvoiceByCode(2);
		GetInvoiceSimpleDto simpleDto = mapper.mapInvoiceDaoToSimpleDto(dao);

		assertEquals(dao.getCode(), simpleDto.getCode());
		assertEquals(dao.getDateCreated(), simpleDto.getDateCreated());
		assertEquals(dao.getDateFinalized(), simpleDto.getDateFinalized());
		assertEquals(dao.getTotalDue(), simpleDto.getTotalDue());
		assertEquals(dao.getTotalAfterDiscount(), simpleDto.getTotalAfterDiscount());
		assertEquals(dao.getTotalPaid(), simpleDto.getTotalPaid());
		assertEquals(dao.getTotalRemaining(), simpleDto.getTotalRemaining());
		assertEquals(dao.getStatus(), simpleDto.getStatus());
		assertEquals(dao.getDiscount(), simpleDto.getDiscount());
		assertEquals(dao.getUserFinalizedBy(), simpleDto.getUserFinalizedBy());
		assertEquals(dao.getAppointment().getCode(), simpleDto.getAppointmentCode());
		assertEquals(dao.getPaymentMethod(), simpleDto.getPaymentMethod());

		if (dao.getPatientMembershipSubscriber() != null)
		{
			assertEquals(dao.getPatientMembershipSubscriber().getName(), simpleDto.getPatientName());

		}
	}

	@Test
	void assertInvoiceDaoEqualsFullDto()
	{
		resInvoice dao = servInvoice.getInvoiceByCode(2);
		GetInvoiceFullDto simpleDto = mapper.mapInvoiceDaoToFullDto(dao);
		assertEquals(dao.getCode(), simpleDto.getCode());
		assertEquals(dao.getDateCreated(), simpleDto.getDateCreated());
		assertEquals(dao.getDateFinalized(), simpleDto.getDateFinalized());
		assertEquals(dao.getTotalDue(), simpleDto.getTotalDue());
		assertEquals(dao.getTotalAfterDiscount(), simpleDto.getTotalAfterDiscount());
		assertEquals(dao.getTotalPaid(), simpleDto.getTotalPaid());
		assertEquals(dao.getTotalRemaining(), simpleDto.getTotalRemaining());
		assertEquals(dao.getStatus(), simpleDto.getStatus());
		assertEquals(dao.getDiscount(), simpleDto.getDiscount());
		assertEquals(dao.getUserFinalizedBy(), simpleDto.getUserFinalizedBy());
		assertEquals(dao.getPaymentMethod(), simpleDto.getPaymentMethod());
		assertTrue(assertAppointmentDaoEqualsSimpleDto(dao.getAppointment(), simpleDto.getAppointment()));

		if (dao.getPatientMembershipSubscriber() != null)
		{
			assertTrue(assertPatientDaoEqualSimpleDto(dao.getAppointment().getPatient(),
					simpleDto.getPatientMembershipSubscriber()));

		}
		if(dao.getUsedMembership() !=null){

		assertTrue(assertMembershipDaoEqualsSimpleDto(dao.getUsedMembership(),simpleDto.getUsedMembership()));
		}
		assertTrue(dao.getInvoiceItems().containsAll(simpleDto.getInvoiceItems()));
	}
}
