package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resAppointment;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/appointment")
@Api(tags = "Appointment")
public interface contIntAppointment {


    @RequestMapping(method = RequestMethod.GET)
    List<resAppointment> getAppointmentAll();

    @RequestMapping(method = RequestMethod.GET, value = "/patientdoctor")
    List<resAppointment> getAppointmentPatientDoctor(@RequestParam("patientCode")long patientCode,
                                                     @RequestParam("doctorCode")long doctorCode);

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/date")
    List<resAppointment> getAppointmentsByDate(@RequestParam("date") String date) throws ParseException;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/past")
    List<resAppointment> getPastAppointments() throws ParseException;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/upcoming")
    List<resAppointment> getUpcomingAppointments();

    @RequestMapping(method = RequestMethod.GET, value = "/upcoming/doctor/{doctorCode}")
    List<resAppointment> getUpcomingAppointmentsDoctor(@PathVariable("doctorCode") long doctorCode);

    @RequestMapping(method = RequestMethod.GET, value = "/past/doctor/{doctorCode}")
    List<resAppointment> getPastAppointmentsDoctor(@PathVariable("doctorCode") long doctorCode) throws ParseException;



    @RequestMapping(method = RequestMethod.GET, value = "/upcoming/patient/{patientCode}")
    List<resAppointment> getUpcomingAppointmentsPatient(@PathVariable("patientCode") long patientCode) throws ParseException;

    @RequestMapping(method = RequestMethod.GET, value = "/past/patient/{patientCode}")
    List<resAppointment> getPastAppointmentsPatient(@PathVariable("patientCode") long patientCode) throws ParseException;


    @RequestMapping(method = RequestMethod.GET, value = "/date/doctor/{doctorCode}")
    List<resAppointment> getDoctorAppointmentsByDate(@RequestParam("date") String date, @PathVariable("doctorCode") long patientCode) throws ParseException;

    @RequestMapping(method = RequestMethod.GET, value = "/{appointmentCode}")
    resAppointment getAppointmentById(@PathVariable("appointmentCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addAppointment(@RequestBody resAppointment newAppointment);

    @RequestMapping(method = RequestMethod.PUT,value="/{appointmentCode}")
    void updateAppointment(@PathVariable("appointmentCode") long code, @RequestBody resAppointment updatedAppointment);

    @RequestMapping(method= RequestMethod.DELETE,value="/{appointmentCode}")
    void deleteAppointment(@PathVariable("appointmentCode") long code);
}
