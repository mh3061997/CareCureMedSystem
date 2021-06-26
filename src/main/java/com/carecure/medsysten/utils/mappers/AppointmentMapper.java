package com.carecure.medsysten.utils.mappers;

import com.carecure.medsysten.dtos.appointment.GetAppointmentSimpleDto;
import com.carecure.medsysten.resources.resAppointment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AppointmentMapper
{
	@Autowired
	private ModelMapper mapper;

	public GetAppointmentSimpleDto mapAppointmentDaoToSimpleDto(GetAppointmentSimpleDto dao)
	{
		return mapper.map(dao, GetAppointmentSimpleDto.class);
	}

	public List<GetAppointmentSimpleDto> mapAppointmentDaoToSimpleDto(List<resAppointment> daoList)
	{
		List<GetAppointmentSimpleDto> getAppointmentSimpleDtoList = new ArrayList<>();

		daoList.forEach(dao -> getAppointmentSimpleDtoList.add(mapper.map(dao, GetAppointmentSimpleDto.class)));

		return getAppointmentSimpleDtoList;

	}

}
