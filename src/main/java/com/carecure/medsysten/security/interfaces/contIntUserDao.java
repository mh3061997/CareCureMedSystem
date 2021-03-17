package com.carecure.medsysten.security.interfaces;

import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.security.models.UserDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/userDao")
public interface contIntUserDao {

    @RequestMapping
    List<UserDao> getUserDaoAll();


    @RequestMapping(method = RequestMethod.PUT,value="/{userDaoCode}/pw")
    void updateUserDaoPassword(@PathVariable("userDaoCode") long code, @RequestBody UserDao updatedUserDao);

    @RequestMapping(method= RequestMethod.PUT,value="/{userDaoCode}/disable")
    void disableUserDao(@PathVariable("userDaoCode") long code);

    @RequestMapping(method= RequestMethod.PUT,value="/{userDaoCode}/enable")
    void enableUserDao(@PathVariable("userDaoCode") long code);

    @RequestMapping(method= RequestMethod.PUT,value="/{userDaoCode}/role")
    void changeRoleUserDao(@PathVariable("userDaoCode") long code,@RequestBody UserDao updatedUserDao);

    @RequestMapping(method = RequestMethod.GET,value="/patient")
    ResponseEntity<?> isPatientAssociatedWithAUser(@RequestParam  String mobile);

    @RequestMapping(method = RequestMethod.GET,value="/doctor")
    ResponseEntity<?> isDoctorAssociatedWithAUser(@RequestParam  String mobile);
}


