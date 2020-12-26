package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntDoctor;
import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.services.servDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class implDoctor implements contIntDoctor {

    @Autowired
    private servDoctor servDoctor;


    @Override
    public List<resDoctor> getDoctorAll() {
        return servDoctor.getDoctorAll();
    }

    @Override
    public resDoctor getDoctorById(long code) {
        return servDoctor.getDoctorByCode(code);
    }

    @Override
    public void addDoctor(resDoctor newDoctor) {
        servDoctor.addDoctor(newDoctor);
    }

    @Override
    public void updateDoctor(long code, resDoctor updatedDoctor) {
        servDoctor.updateDoctor(code,updatedDoctor);
    }

    @Override
    public void deleteDoctor(long code) {
        servDoctor.deleteDoctor(code);
    }
}
