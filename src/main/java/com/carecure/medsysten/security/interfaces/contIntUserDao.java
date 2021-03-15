package com.carecure.medsysten.security.interfaces;

import com.carecure.medsysten.security.models.UserDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}


