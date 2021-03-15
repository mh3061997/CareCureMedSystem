package com.carecure.medsysten.security.controller;
import com.carecure.medsysten.security.interfaces.contIntUserDao;
import com.carecure.medsysten.security.models.UserDao;
import com.carecure.medsysten.security.service.servUserDao;
import org.springframework.beans.factory.annotation.Autowired;
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
}




