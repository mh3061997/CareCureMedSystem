package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntAppointment;
import com.carecure.medsysten.resources.resAppointment;
import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.services.servAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class implAppointment implements contIntAppointment {

    @Autowired
    private servAppointment servAppointment;


    @Override
    public List<resAppointment> getAppointmentAll() {
        List<resAppointment> jsonAppointments = new ArrayList<>();
         servAppointment.getAppointmentAll().forEach(appointment -> {
             resPatient patient = appointment.getPatient();
             patient.setAppointments(new ArrayList<>());
             patient.setMemberships(new ArrayList<>());

             resDoctor doctor = appointment.getDoctor();
             doctor.setAppointments(new ArrayList<>());

             appointment.setPatient(patient);
             appointment.setDoctor(doctor);

             jsonAppointments.add(appointment);

         });
         return jsonAppointments;
    }

    @Override
    public resAppointment getAppointmentById(long code) {

        resAppointment appointment =  servAppointment.getAppointmentByCode(code);

        resPatient patient = appointment.getPatient();
        patient.setAppointments(new ArrayList<>());
        patient.setMemberships(new ArrayList<>());

        resDoctor doctor = appointment.getDoctor();
        doctor.setAppointments(new ArrayList<>());

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

       return appointment;
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
