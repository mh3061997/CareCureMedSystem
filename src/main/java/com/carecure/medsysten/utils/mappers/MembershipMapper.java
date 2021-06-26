package com.carecure.medsysten.utils.mappers;

import com.carecure.medsysten.dtos.membership.GetMembershipSimpleDto;
import com.carecure.medsysten.resources.resPackageMembership;

import java.util.ArrayList;
import java.util.List;

public class MembershipMapper
{

	public static GetMembershipSimpleDto mapMembershipDaoToSimpleDto(resPackageMembership dao)
	{

		GetMembershipSimpleDto getMembershipSimpleDto = new GetMembershipSimpleDto();

		getMembershipSimpleDto.setCode(dao.getCode());
		getMembershipSimpleDto.setDateSubscriped(dao.getDateSubscriped());
		getMembershipSimpleDto.setUsedAmount(dao.getUsedAmount());
		getMembershipSimpleDto.setRemainingAmount(dao.getRemainingAmount());
		getMembershipSimpleDto.setPatientCode(dao.getPatient().getCode());
		getMembershipSimpleDto.setPatientName(dao.getPatient().getName());
		getMembershipSimpleDto.setPackageCode(dao.getPackageBase().getCode());
		getMembershipSimpleDto.setPackageName(dao.getPackageBase().getName());

		return getMembershipSimpleDto;

	}

	public static List<GetMembershipSimpleDto> mapMembershipDaoToSimpleDto(List<resPackageMembership> daoList)
	{

		List<GetMembershipSimpleDto> getMembershipSimpleDtoList = new ArrayList<>();

		daoList.forEach(dao -> {

			GetMembershipSimpleDto getMembershipSimpleDto = new GetMembershipSimpleDto();
			getMembershipSimpleDto.setCode(dao.getCode());
			getMembershipSimpleDto.setDateSubscriped(dao.getDateSubscriped());
			getMembershipSimpleDto.setUsedAmount(dao.getUsedAmount());
			getMembershipSimpleDto.setRemainingAmount(dao.getRemainingAmount());
			getMembershipSimpleDto.setPatientCode(dao.getPatient().getCode());
			getMembershipSimpleDto.setPatientName(dao.getPatient().getName());
			getMembershipSimpleDto.setPackageCode(dao.getPackageBase().getCode());
			getMembershipSimpleDto.setPackageName(dao.getPackageBase().getName());
			daoList.add(dao);

		});

		return getMembershipSimpleDtoList;

	}
}
