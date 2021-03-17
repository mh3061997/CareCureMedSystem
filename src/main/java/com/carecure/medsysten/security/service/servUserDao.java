package com.carecure.medsysten.security.service;

import com.carecure.medsysten.repositories.repoDoctor;
import com.carecure.medsysten.repositories.repoPatient;
import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.security.models.UserDao;
import com.carecure.medsysten.security.models.UserRepository;
import com.carecure.medsysten.security.models.role;
import com.carecure.medsysten.security.models.roleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class servUserDao {

    @Autowired
    UserRepository repoUserDao;

    @Autowired
    roleRepository roleRepository;

    @Autowired
    repoPatient repoPatient;

    @Autowired
    com.carecure.medsysten.repositories.repoDoctor repoDoctor;

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

    public void changeUserDaoRole(long code, UserDao updatedDao) {
        Optional<UserDao> userDao = repoUserDao.findById(code);
        if (userDao.isPresent()) {
            UserDao updatedRoleDao = userDao.get();

            Set<role> newRoles = new HashSet<>();
            updatedDao.getRoles().forEach(role -> {
                role roleDB = roleRepository.findByname(role.getName());
                newRoles.add(roleDB);
            });
            updatedRoleDao.setRoles(newRoles);
            repoUserDao.save(updatedRoleDao);
        } else
            //throw exception
            return;
    }

    public ResponseEntity<?> isPatientAssociatedWithAUser(String mobile) {
        resPatient patient = repoPatient.findByMobile(mobile);
        if (patient != null) {
            UserDao user = repoUserDao.findByPatientCode(patient.getCode());

            if (user != null) {

                HashMap<String, String> errorMessageMap = new HashMap<>();
                errorMessageMap.put("message", "Patient is already associated to a user");

                return new ResponseEntity<>(errorMessageMap, HttpStatus.IM_USED);

            } else {
                patient.setMemberships(new ArrayList<>());
                patient.setAppointments(new ArrayList<>());
                patient.setMedImages(new ArrayList<>());
                return new ResponseEntity<>(patient, HttpStatus.ACCEPTED);
            }

        } else
        {
            HashMap<String, String> errorMessageMap = new HashMap<>();
            errorMessageMap.put("message", "No Patient Found with this number");
            System.out.println(errorMessageMap.toString());
            return new ResponseEntity<>(errorMessageMap, HttpStatus.NON_AUTHORITATIVE_INFORMATION);

        }

    }

    public ResponseEntity<?> isDoctorAssociatedWithAUser(String mobile) {
        resDoctor doctor = repoDoctor.findByMobile(mobile);
        if (doctor != null) {
            UserDao user = repoUserDao.findByDoctorCode(doctor.getCode());

            if (user != null) {

                HashMap<String, String> errorMessageMap = new HashMap<>();
                errorMessageMap.put("message", "Doctor is already associated to a user");

                return new ResponseEntity<>(errorMessageMap, HttpStatus.IM_USED);

            } else {

                doctor.setAppointments(new ArrayList<>());
                doctor.setAvailableDays(new ArrayList<>());

                return new ResponseEntity<>(doctor, HttpStatus.ACCEPTED);
            }

        } else
        {
            HashMap<String, String> errorMessageMap = new HashMap<>();
            errorMessageMap.put("message", "No Doctor Found with this number");
            System.out.println(errorMessageMap.toString());
            return new ResponseEntity<>(errorMessageMap, HttpStatus.NON_AUTHORITATIVE_INFORMATION);

        }

    }

}





