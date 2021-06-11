package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resDoctorDayAvail;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/doctorDayAvail")
@Api(tags = "Working Days Doctor")
public interface contIntDoctorDayAvail {

    @RequestMapping(method = RequestMethod.GET)
    List<resDoctorDayAvail> getDoctorDayAvailAll();

    @RequestMapping(method = RequestMethod.GET,value = "/{doctorDayAvailCode}")
    resDoctorDayAvail getDoctorDayAvailById(@PathVariable("doctorDayAvailCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addDoctorDayAvail(@RequestBody resDoctorDayAvail newDoctorDayAvail);

    @RequestMapping(method = RequestMethod.POST,value="/addmulti")
    void  addDoctorDayMulti(@RequestBody List<resDoctorDayAvail> newDoctorDayAvailArr);

    @RequestMapping(method = RequestMethod.PUT,value="/{doctorDayAvailCode}")
    void updateDoctorDayAvail(@PathVariable("doctorDayAvailCode") long code, @RequestBody resDoctorDayAvail updatedDoctorDayAvail);

    @RequestMapping(method = RequestMethod.PUT,value="/updatemulti")
    void   updateDoctorDayAvailMulti(@PathParam("doctorCode") long doctorCode,@RequestBody List<resDoctorDayAvail> updatedDoctorDayAvailArr);


    @RequestMapping(method= RequestMethod.DELETE,value="/{doctorDayAvailCode}")
    void deleteDoctorDayAvail(@PathVariable("doctorDayAvailCode") long code);
}
