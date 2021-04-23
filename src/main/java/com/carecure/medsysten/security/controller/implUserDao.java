package com.carecure.medsysten.security.controller;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.security.interfaces.contIntUserDao;
import com.carecure.medsysten.security.models.UserDao;
import com.carecure.medsysten.security.service.servUserDao;
import com.carecure.medsysten.services.servDoctor;
import com.carecure.medsysten.services.servPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin
@RestController
public class implUserDao implements contIntUserDao {

    @Autowired
    servUserDao servUserDao;

    @Override
    public List<UserDao> getUserDaoAll() {
        return servUserDao.getUserDaoAll();
    }

    @Override
    public void updateUserDaoPassword(long code, UserDao updatedUserDao) {
        servUserDao.updateUserDaoPassword(code,updatedUserDao);
    }

    @Override
    public void disableUserDao(long code) {
        servUserDao.disableUserDao(code);
    }

    @Override
    public void enableUserDao(long code) {
        servUserDao.enableUserDao(code);
    }

    @Override
    public void changeRoleUserDao(long code, UserDao updatedUserDao) {
        servUserDao.changeUserDaoRole(code,updatedUserDao);
    }

    @Override
    public ResponseEntity<?> isPatientAssociatedWithAUser(String mobile) {
        return servUserDao.isPatientAssociatedWithAUser(mobile);
    }

    @Override
    public ResponseEntity<?> isDoctorAssociatedWithAUser(String mobile) {
        return servUserDao.isDoctorAssociatedWithAUser(mobile);
    }

}




