package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resDoctor;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/doctor")
@Api(tags = "Doctor")
public interface contIntDoctor {

    @RequestMapping(method = RequestMethod.GET)
    List<resDoctor> getDoctorAll();

    @RequestMapping(method = RequestMethod.GET,value = "/speciality")
    public List<resDoctor> getDoctorAllBySpeciality(@RequestParam String speciality);

    @RequestMapping(method = RequestMethod.GET,value = "/{doctorCode}")
    resDoctor getDoctorById(@PathVariable("doctorCode") long code);

    @RequestMapping(method = RequestMethod.GET,value = "/{doctorCode}/reservedTimes")
    List<doctorReservedTimes> getDoctorReservedTimesByDate(@PathVariable("doctorCode") long doctorCode,@RequestParam("date") String date);


    @RequestMapping(method = RequestMethod.POST)
    resDoctor addDoctor(@RequestBody resDoctor newDoctor);

    @RequestMapping(method = RequestMethod.PUT,value="/{doctorCode}")
    void updateDoctor(@PathVariable("doctorCode") long code, @RequestBody resDoctor updatedDoctor);

    @RequestMapping(method= RequestMethod.DELETE,value="/{doctorCode}")
    void deleteDoctor(@PathVariable("doctorCode") long code);
}
