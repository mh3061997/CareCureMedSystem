package com.carecure.medsysten.mapper;

import com.carecure.medsysten.dtos.appointment.GetAppointmentFullDto;
import com.carecure.medsysten.dtos.appointment.GetAppointmentSimpleDto;
import com.carecure.medsysten.resources.resAppointment;
import com.carecure.medsysten.services.servAppointment;
import com.carecure.medsysten.utils.mappers.AppointmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.carecure.medsysten.testUtils.*;
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



}
