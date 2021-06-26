package com.carecure.medsysten.utils.mappers;

import com.carecure.medsysten.dtos.patient.GetPatientFullDto;
import com.carecure.medsysten.dtos.patient.GetPatientSimpleDto;
import com.carecure.medsysten.resources.resPatient;

public class PatientMapper
{

	public static GetPatientSimpleDto mapPatientDaoToSimpleDto(resPatient dao)
	{

		GetPatientSimpleDto patientDto = new GetPatientSimpleDto();

		patientDto.setAge(dao.getAge());
		patientDto.setCode(dao.getCode());
		patientDto.setTotalDebt(dao.getTotalDebt());
		patientDto.setGender(dao.getGender());
		patientDto.setName(dao.getName());
		patientDto.setMobile(dao.getMobile());

		return patientDto;
	}

	public static GetPatientFullDto mapPatientDaoToFullDto(resPatient dao)
	{

		GetPatientFullDto patientDto = new GetPatientFullDto();

		patientDto.setCode(dao.getCode());
		patientDto.setName(dao.getName());
		patientDto.setGender(dao.getGender());
		patientDto.setEmail(dao.getEmail());
		patientDto.setMobile(dao.getMobile());
		patientDto.setAge(dao.getAge());
		patientDto.setTotalDebt(dao.getTotalDebt());
		patientDto.setNotes(dao.getNotes());

		patientDto.setMemberships(MembershipMapper.mapMembershipDaoToSimpleDto(dao.getMemberships()));
		patientDto.setMedImages(dao.getMedImages());
		//patientDto.setInvoices();
		patientDto.setAppointments(AppointmentMapper.mapAppointmentDaoToSimpleDto(dao.getAppointments()));
		return patientDto;
	}
}
