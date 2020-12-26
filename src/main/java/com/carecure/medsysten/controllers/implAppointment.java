package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntAppointment;
import com.carecure.medsysten.resources.resAppointment;
import com.carecure.medsysten.services.servAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class implAppointment implements contIntAppointment {

    @Autowired
    private servAppointment servAppointment;


    @Override
    public List<resAppointment> getAppointmentAll() {
        return servAppointment.getAppointmentAll();
    }

    @Override
    public resAppointment getAppointmentById(long code) {
        return servAppointment.getAppointmentByCode(code);
    }

    @Override
    public void addAppointment(resAppointment newAppointment) {
        servAppointment.addAppointment(newAppointment);
    }

    @Override
    public void updateAppointment(long code, resAppointment updatedAppointment) {
        servAppointment.updateAppointment(code,updatedAppointment);
    }

    @Override
    public void deleteAppointment(long code) {
        servAppointment.deleteAppointment(code);
    }
}
