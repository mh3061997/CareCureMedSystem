package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resAppointment;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RequestMapping("/appointment")
public interface contIntAppointment {

    @RequestMapping
    List<resAppointment> getAppointmentAll();

    @RequestMapping("/patientdoctor")
    List<resAppointment> getAppointmentPatientDoctor(@RequestParam("patientCode")long patientCode,
                                                     @RequestParam("doctorCode")long doctorCode);

    @RequestMapping("/past")
    List<resAppointment> getPastAppointments() throws ParseException;

    @RequestMapping("/upcoming")
    List<resAppointment> getUpcomingAppointments() throws ParseException;

    @RequestMapping("/upcoming/doctor/{doctorCode}")
    List<resAppointment> getUpcomingAppointmentsDoctor(@PathVariable("doctorCode") long doctorCode) throws ParseException;

    @RequestMapping("/past/doctor/{doctorCode}")
    List<resAppointment> getPastAppointmentsDoctor(@PathVariable("doctorCode") long doctorCode) throws ParseException;



    @RequestMapping("/upcoming/patient/{patientCode}")
    List<resAppointment> getUpcomingAppointmentsPatient(@PathVariable("patientCode") long patientCode) throws ParseException;

    @RequestMapping("/past/patient/{patientCode}")
    List<resAppointment> getPastAppointmentsPatient(@PathVariable("patientCode") long patientCode) throws ParseException;


    @RequestMapping("/date/{doctorCode}")
    List<resAppointment> getDoctorAppointmentsByDate(@RequestParam("date") String date, @PathVariable("doctorCode") long patientCode) throws ParseException;

    @RequestMapping("/{appointmentCode}")
    resAppointment getAppointmentById(@PathVariable("appointmentCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addAppointment(@RequestBody resAppointment newAppointment);

    @RequestMapping(method = RequestMethod.PUT,value="/{appointmentCode}")
    void updateAppointment(@PathVariable("appointmentCode") long code, @RequestBody resAppointment updatedAppointment);

    @RequestMapping(method= RequestMethod.DELETE,value="/{appointmentCode}")
    void deleteAppointment(@PathVariable("appointmentCode") long code);
}
