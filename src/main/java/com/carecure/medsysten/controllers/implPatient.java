package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntPatient;
import com.carecure.medsysten.resources.resAppointment;
import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.services.servPatient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class implPatient implements contIntPatient {

    @Autowired
    private servPatient servPatient;


    @Override
    public List<resPatient> getPatientAll() {
        List<resPatient> jsonPatients = new ArrayList<>();

        servPatient.getPatientAll().forEach(patient -> {
            List<resAppointment> appointments = new ArrayList<>();
            patient.getAppointments().forEach(appointment -> {
                appointment.setPatient(null);
                resDoctor doctor =appointment.getDoctor();
                doctor.setAppointments(new ArrayList<>());
                appointment.setDoctor(doctor);
                appointments.add(appointment);
            });
            patient.setAppointments(appointments);
            jsonPatients.add(patient);
        });

        return jsonPatients;
    }

    @Override
    public resPatient getPatientById(long code) {
        resPatient patient = servPatient.getPatientByCode(code);
        List<resAppointment> appointments = new ArrayList<>();
        patient.getAppointments().forEach(appointment -> {
            appointment.setPatient(null);
            resDoctor doctor =appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());
            appointment.setDoctor(doctor);
            appointments.add(appointment);
        });
        patient.setAppointments(appointments);
        return patient;
        //return servPatient.getPatientByCode(code);
    }

    @Override
    public void addPatient(resPatient newPatient) {
        servPatient.addPatient(newPatient);
    }

    @Override
    public void updatePatient(long code, resPatient updatedPatient) {
        servPatient.updatePatient(code,updatedPatient);
    }

    @Override
    public void deletePatient(long code) {
        servPatient.deletePatient(code);
    }
}
