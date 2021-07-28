package com.carecure.medsysten;

import com.carecure.medsysten.dtos.appointment.GetAppointmentSimpleDto;
import com.carecure.medsysten.dtos.doctor.GetDoctorSimpleDto;
import com.carecure.medsysten.dtos.invoice.GetInvoiceSimpleDto;
import com.carecure.medsysten.dtos.membership.GetMembershipSimpleDto;
import com.carecure.medsysten.dtos.patient.GetPatientSimpleDto;
import com.carecure.medsysten.resources.*;

public class testUtils
{
	public static boolean assertPatientDaoEqualSimpleDto(resPatient dao, GetPatientSimpleDto fullDto)
	{
		return fullDto.getAge() == dao.getAge() && fullDto.getCode() == dao.getCode() && fullDto.getTotalDebt() == dao
				.getTotalDebt() && fullDto.getGender().equals(dao.getGender()) && fullDto.getName().equals(dao.getName())
				&& fullDto.getMobile().equals(dao.getMobile());

	}

	public static boolean assertDoctorDaoEqualSimpleDto(resDoctor dao, GetDoctorSimpleDto fullDto)
	{
		return fullDto.getAge() == dao.getAge() && fullDto.getCode() == dao.getCode() && fullDto.getSpeciality()
				.equals(dao.getSpeciality()) && fullDto.getGender().equals(dao.getGender()) && fullDto.getName()
				.equals(dao.getName()) && fullDto.getMobile().equals(dao.getMobile()) && fullDto.getEmail()
				.equals(dao.getEmail()) && fullDto.getPriceVisit() == dao.getPriceVisit() && fullDto.getPriceRevisit() == dao
				.getPriceRevisit();

	}

	public static boolean assertInvoiceDaoEqualsSimpleDto(resInvoice dao, GetInvoiceSimpleDto simpleDto)
	{

		if (dao.getPatientMembershipSubscriber() != null && !dao.getPatientMembershipSubscriber().getName()
				.equals(simpleDto.getPatientName()))
		{
			return false;
		}
		return dao.getCode() == simpleDto.getCode() && dao.getDateCreated().equals(simpleDto.getDateCreated()) && dao
				.getDateFinalized().equals(simpleDto.getDateFinalized()) && dao.getTotalDue() == simpleDto.getTotalDue()
				&& dao.getTotalAfterDiscount() == simpleDto.getTotalAfterDiscount() && dao.getTotalPaid() == simpleDto
				.getTotalPaid() && dao.getTotalRemaining() == simpleDto.getTotalRemaining() && dao.getStatus()
				.equals(simpleDto.getStatus()) && dao.getDiscount() == simpleDto.getDiscount() && dao.getUserFinalizedBy()
				.equals(simpleDto.getUserFinalizedBy()) && dao.getAppointment().getCode() == simpleDto.getAppointmentCode()
				&& dao.getPaymentMethod().equals(simpleDto.getPaymentMethod());
	}

	public static boolean assertAppointmentDaoEqualsSimpleDto(resAppointment dao, GetAppointmentSimpleDto dto)
	{
		if (dao.getUserLoggerName() != null && !dao.getUserLoggerName().equals(dto.getUserLoggerName()))
		{
			return false;
		}
		return dao.getCode() == dto.getCode() && dao.getSpeciality().equals(dto.getSpeciality()) && dao.getDateCreated()
				.equals(dto.getDateCreated()) && dao.getDateToVisit().equals(dto.getDateToVisit()) && dao.getType()
				.equals(dto.getType()) && dao.getStatus().equals(dto.getStatus()) && dao.getNotes().equals(dto.getNotes())
				&& dao.getPatient().getCode() == dto.getPatientCode() && dao.getPatient().getName()
				.equals(dto.getPatientName()) && dao.getPatient().getMobile().equals(dto.getPatientMobile())
				&& dao.getDoctor().getCode() == (dto.getDoctorCode()) && dao.getDoctor().getName()
				.equals(dto.getDoctorName());

	}

	public static boolean assertMembershipDaoEqualsSimpleDto(resPackageMembership dao, GetMembershipSimpleDto dto)
	{
		return dao.getCode() == dto.getCode() && dao.getDateSubscriped().equals(dto.getDateSubscriped())
				&& dao.getRemainingAmount() == dto.getRemainingAmount() && dao.getUsedAmount() == dto.getUsedAmount()
				&& dao.getPatient().getCode() == dto.getPatientCode() && dao.getPatient().getName()
				.equals(dto.getPatientName()) && dao.getPackageBase().getCode() == dto.getPackageCode() && dao
				.getPackageBase().getName().equals(dto.getPackageName());
	}

}
