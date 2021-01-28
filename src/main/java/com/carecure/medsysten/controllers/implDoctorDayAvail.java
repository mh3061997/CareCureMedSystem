package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntDoctorDayAvail;
import com.carecure.medsysten.resources.resDoctorDayAvail;
import com.carecure.medsysten.services.servDoctorDayAvail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class implDoctorDayAvail implements contIntDoctorDayAvail {

    @Autowired
    private servDoctorDayAvail servDoctorDayAvail;

    @CrossOrigin
    @Override
    public List<resDoctorDayAvail> getDoctorDayAvailAll() {
        return servDoctorDayAvail.getDoctorDayAvailAll();
    }

    @Override
    public resDoctorDayAvail getDoctorDayAvailById(long code) {
        return servDoctorDayAvail.getDoctorDayAvailByCode(code);
    }

    @Override
    public void addDoctorDayAvail(resDoctorDayAvail newDoctorDayAvail) {
        servDoctorDayAvail.addDoctorDayAvail(newDoctorDayAvail);
    }

    @Override
    public void updateDoctorDayAvail(long code, resDoctorDayAvail updatedDoctorDayAvail) {
        servDoctorDayAvail.updateDoctorDayAvail(code,updatedDoctorDayAvail);
    }

    @Override
    public void deleteDoctorDayAvail(long code) {
        servDoctorDayAvail.deleteDoctorDayAvail(code);
    }
}
