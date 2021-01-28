package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resDoctorDayAvail;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/doctorDayAvail")
public interface contIntDoctorDayAvail {

    @RequestMapping
    List<resDoctorDayAvail> getDoctorDayAvailAll();

    @RequestMapping("/{doctorDayAvailCode}")
    resDoctorDayAvail getDoctorDayAvailById(@PathVariable("doctorDayAvailCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addDoctorDayAvail(@RequestBody resDoctorDayAvail newDoctorDayAvail);

    @RequestMapping(method = RequestMethod.PUT,value="/{doctorDayAvailCode}")
    void updateDoctorDayAvail(@PathVariable("doctorDayAvailCode") long code, @RequestBody resDoctorDayAvail updatedDoctorDayAvail);

    @RequestMapping(method= RequestMethod.DELETE,value="/{doctorDayAvailCode}")
    void deleteDoctorDayAvail(@PathVariable("doctorDayAvailCode") long code);
}
