package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resAppointment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/appointment")
public interface contIntAppointment {

    @RequestMapping
    List<resAppointment> getAppointmentAll();

    @RequestMapping("/{appointmentCode}")
    resAppointment getAppointmentById(@PathVariable("appointmentCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addAppointment(@RequestBody resAppointment newAppointment);

    @RequestMapping(method = RequestMethod.PUT,value="/{appointmentCode")
    void updateAppointment(@PathVariable("appointmentCode") long code, @RequestBody resAppointment updatedAppointment);

    @RequestMapping(method= RequestMethod.DELETE,value="/{appointmentCode")
    void deleteAppointment(@PathVariable("appointmentCode") long code);
}
