package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resDoctor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctor")
public interface contIntDoctor {

    @RequestMapping
    List<resDoctor> getDoctorAll();

    @RequestMapping("/speciality")
    public List<resDoctor> getDoctorAllBySpeciality(@RequestParam String speciality);

    @RequestMapping("/{doctorCode}")
    resDoctor getDoctorById(@PathVariable("doctorCode") long code);

    @RequestMapping("/{doctorCode}/reservedTimes")
    List<doctorReservedTimes> getDoctorReservedTimesByDate(@PathVariable("doctorCode") long doctorCode,@RequestParam("date") String date);


    @RequestMapping(method = RequestMethod.POST)
    void addDoctor(@RequestBody resDoctor newDoctor);

    @RequestMapping(method = RequestMethod.PUT,value="/{doctorCode}")
    void updateDoctor(@PathVariable("doctorCode") long code, @RequestBody resDoctor updatedDoctor);

    @RequestMapping(method= RequestMethod.DELETE,value="/{doctorCode}")
    void deleteDoctor(@PathVariable("doctorCode") long code);
}
