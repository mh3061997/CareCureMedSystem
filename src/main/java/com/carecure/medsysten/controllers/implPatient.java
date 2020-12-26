package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntPatient;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.services.servPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class implPatient implements contIntPatient {

    @Autowired
    private servPatient servPatient;


    @Override
    public List<resPatient> getPatientAll() {
        return servPatient.getPatientAll();
    }

    @Override
    public resPatient getPatientById(long code) {
        return servPatient.getPatientByCode(code);
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
