package com.carecure.medsysten.security.controller;

import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.security.interfaces.contIntUserDao;
import com.carecure.medsysten.security.models.UserDao;
import com.carecure.medsysten.security.service.servUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class implUserDao implements contIntUserDao
{

	@Autowired
	servUserDao servUserDao;

	@Override
	public List<UserDao> getUserDaoAll()
	{
		List<UserDao> usersJson = new ArrayList<>();
		servUserDao.getUserDaoAll().forEach(userDao -> {
            resPatient patient = userDao.getPatient();
            resDoctor doctor =  userDao.getDoctor();

            if(patient != null) {
                patient.setInvoiceMemberships(new ArrayList<>());
                patient.setAppointments(new ArrayList<>());
                patient.setMemberships(new ArrayList<>());
                patient.setMedImages(new ArrayList<>());
            }
            if( doctor !=null ) {
                doctor.setAvailableDays(new ArrayList<>());
                doctor.setAppointments(new ArrayList<>());

            }
            userDao.setPatient(patient);
            userDao.setDoctor(doctor);
            usersJson.add(userDao);
		});
		return  usersJson;
	}

	@Override
	public void updateUserDaoPassword(long code, UserDao updatedUserDao)
	{
		servUserDao.updateUserDaoPassword(code, updatedUserDao);
	}

	@Override
	public void disableUserDao(long code)
	{
		servUserDao.disableUserDao(code);
	}

	@Override
	public void enableUserDao(long code)
	{
		servUserDao.enableUserDao(code);
	}

	@Override
	public void changeRoleUserDao(long code, UserDao updatedUserDao)
	{
		servUserDao.changeUserDaoRole(code, updatedUserDao);
	}

	@Override
	public ResponseEntity<?> isPatientAssociatedWithAUser(String mobile)
	{
		return servUserDao.isPatientAssociatedWithAUser(mobile);
	}

	@Override
	public ResponseEntity<?> isDoctorAssociatedWithAUser(String mobile)
	{
		return servUserDao.isDoctorAssociatedWithAUser(mobile);
	}

}




