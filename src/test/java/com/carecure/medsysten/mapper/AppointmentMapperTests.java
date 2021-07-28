package com.carecure.medsysten.mapper;

import com.carecure.medsysten.dtos.appointment.GetAppointmentFullDto;
import com.carecure.medsysten.dtos.appointment.GetAppointmentSimpleDto;
import com.carecure.medsysten.dtos.doctor.GetDoctorSimpleDto;
import com.carecure.medsysten.dtos.invoice.GetInvoiceSimpleDto;
import com.carecure.medsysten.dtos.patient.GetPatientSimpleDto;
import com.carecure.medsysten.resources.resAppointment;
import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resInvoice;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.services.servAppointment;
import com.carecure.medsysten.utils.mappers.AppointmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AppointmentMapperTests
{
	@Autowired
	com.carecure.medsysten.services.servPatient servPatient;

	@Autowired
	servAppointment servAppointment;
	@Autowired
	AppointmentMapper appointmentMapper;

	@Test
	void AppointmentMapperSimpleDaoToSimpleDtoTest()
	{

		resAppointment dao = servAppointment.getAppointmentByCode(1);
		GetAppointmentSimpleDto simpleDto = appointmentMapper.mapAppointmentDaoToSimpleDto(dao);

		assertEquals(dao.getCode(), simpleDto.getCode());
		assertEquals(dao.getSpeciality(), simpleDto.getSpeciality());
		assertEquals(dao.getDateCreated(), simpleDto.getDateCreated());
		assertEquals(dao.getDateToVisit(), simpleDto.getDateToVisit());
		assertEquals(dao.getType(), simpleDto.getType());
		assertEquals(dao.getNotes(), simpleDto.getNotes());
		assertEquals(dao.getStatus(), simpleDto.getStatus());
		assertEquals(dao.getPatient().getCode(), simpleDto.getPatientCode());
		assertEquals(dao.getPatient().getName(), simpleDto.getPatientName());
		assertEquals(dao.getPatient().getMobile(), simpleDto.getPatientMobile());
		assertEquals(dao.getDoctor().getName(), simpleDto.getDoctorName());
		assertEquals(dao.getDoctor().getCode(), simpleDto.getDoctorCode());
		assertEquals(dao.getUserLoggerName(), simpleDto.getUserLoggerName());

	}

	@Test
	void AppointmentMapperSimpleDaoToFullDtoTest()
	{
		resAppointment dao = servAppointment.getAppointmentByCode(1);
		GetAppointmentFullDto fullDto = appointmentMapper.mapAppointmentDaoToFullDto(dao);

		assertEquals(dao.getCode(), fullDto.getCode());
		assertEquals(dao.getSpeciality(), fullDto.getSpeciality());
		assertEquals(dao.getDateCreated(), fullDto.getDateCreated());
		assertEquals(dao.getDateToVisit(), fullDto.getDateToVisit());
		assertEquals(dao.getType(), fullDto.getType());
		assertEquals(dao.getNotes(), fullDto.getNotes());
		assertEquals(dao.getStatus(), fullDto.getStatus());
		assertEquals(dao.getUserLoggerName(), fullDto.getUserCreatedBy());
		assertTrue(assertPatientDaoEqualSimpleDto(dao.getPatient(),fullDto.getPatient()));
		assertTrue(assertDoctorDaoEqualSimpleDto(dao.getDoctor(),fullDto.getDoctor()));
		assertTrue(assertInvoiceDaoEqualsSimpleDto(dao.getInvoice(),fullDto.getInvoice()));
		assertTrue(dao.getDoctorNotes().containsAll(fullDto.getDoctorNotes()));
	}

	public boolean assertPatientDaoEqualSimpleDto(resPatient dao, GetPatientSimpleDto fullDto)
	{
		return fullDto.getAge() == dao.getAge() &&
				fullDto.getCode() == dao.getCode() &&
				fullDto.getTotalDebt() == dao.getTotalDebt() &&
				fullDto.getGender().equals(dao.getGender()) &&
				fullDto.getName().equals(dao.getName()) &&
				fullDto.getMobile().equals(dao.getMobile());

	}

	public boolean assertDoctorDaoEqualSimpleDto(resDoctor dao, GetDoctorSimpleDto fullDto)
	{
		return fullDto.getAge() == dao.getAge() &&
				fullDto.getCode() == dao.getCode() &&
				fullDto.getSpeciality().equals(dao.getSpeciality()) &&
				fullDto.getGender().equals(dao.getGender()) &&
				fullDto.getName().equals(dao.getName()) &&
				fullDto.getMobile().equals(dao.getMobile()) &&
				fullDto.getEmail().equals(dao.getEmail()) &&
				fullDto.getPriceVisit() == dao.getPriceVisit() &&
				fullDto.getPriceRevisit() == dao.getPriceRevisit();

	}

	public boolean assertInvoiceDaoEqualsSimpleDto(resInvoice dao, GetInvoiceSimpleDto simpleDto){
		System.out.println(simpleDto);
		if(dao.getPatientMembershipSubscriber() !=null && !dao.getPatientMembershipSubscriber().getName().equals(simpleDto.getPatientName())){
			return false;
		}
		return dao.getCode() == simpleDto.getCode() &&
				dao.getDateCreated().equals(simpleDto.getDateCreated())&&
				dao.getDateFinalized().equals(simpleDto.getDateFinalized())&&
				dao.getTotalDue() == simpleDto.getTotalDue() &&
				dao.getTotalAfterDiscount() == simpleDto.getTotalAfterDiscount() &&
				dao.getTotalPaid() == simpleDto.getTotalPaid() &&
				dao.getTotalRemaining() == simpleDto.getTotalRemaining() &&
				dao.getStatus().equals(simpleDto.getStatus()) &&
				dao.getDiscount() == simpleDto.getDiscount() &&
				dao.getUserFinalizedBy().equals(simpleDto.getUserFinalizedBy()) &&
				dao.getAppointment().getCode() == simpleDto.getAppointmentCode() &&
				dao.getPaymentMethod().equals(simpleDto.getPaymentMethod());
	}
}
