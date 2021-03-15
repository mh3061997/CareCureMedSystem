package com.carecure.medsysten.security.service;

import com.carecure.medsysten.security.models.UserDao;
import com.carecure.medsysten.security.models.UserRepository;
import com.carecure.medsysten.security.models.role;
import com.carecure.medsysten.security.models.roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class servUserDao {

    @Autowired
    UserRepository repoUserDao;

    @Autowired
    roleRepository roleRepository;

    //return all userDaos in db
    public List<UserDao> getUserDaoAll() {
        List<UserDao> UserDaoList = new ArrayList<>();
        repoUserDao.findAll().forEach(UserDaoList::add);
        return UserDaoList;
    }


    public void updateUserDaoPassword(long userDaoCode, UserDao updatedUserDao) {
        Optional<UserDao> userDao = repoUserDao.findById(userDaoCode);
        if (userDao.isPresent()) {
            UserDao updatedUserPW = userDao.get();
            updatedUserPW.setPassword(updatedUserDao.getPassword());
            repoUserDao.save(updatedUserPW);
        }
    }

    public void disableUserDao(long code) {

        Optional<UserDao> userDao = repoUserDao.findById(code);
        if (userDao.isPresent()) {

            UserDao disabledUser = userDao.get();
            disabledUser.setEnabled(false);
            repoUserDao.save(disabledUser);
        } else
            //throw exception
            return;
    }

    public void enableUserDao(long code) {

        Optional<UserDao> userDao = repoUserDao.findById(code);
        if (userDao.isPresent()) {

            UserDao disabledUser = userDao.get();
            disabledUser.setEnabled(true);
            repoUserDao.save(disabledUser);
        } else
            //throw exception
            return;
    }

    public void changeUserDaoRole(long code,UserDao updatedDao){
        Optional<UserDao> userDao = repoUserDao.findById(code);
        if(userDao.isPresent()){
            UserDao updatedRoleDao =  userDao.get();

            Set<role> newRoles = new HashSet<>();
            updatedDao.getRoles().forEach(role->{
                role roleDB = roleRepository.findByname(role.getName());
                newRoles.add(roleDB);
            });
            updatedRoleDao.setRoles(newRoles);
            repoUserDao.save(updatedRoleDao);
        }
        else
            //throw exception
            return;
    }
}





