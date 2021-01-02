package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntDoctor;
import com.carecure.medsysten.resources.*;
import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.services.servDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
public class implDoctor implements contIntDoctor {

    @Autowired
    private servDoctor servDoctor;


    @Override
    public List<resDoctor> getDoctorAll() {
        List<resDoctor> jsonDoctors = new ArrayList<>();

        servDoctor.getDoctorAll().forEach(doctor -> {
            List<resAppointment> appointments = new ArrayList<>();
            doctor.getAppointments().forEach(appointment -> {
                appointment.setDoctor(null);
                resPatient patient = appointment.getPatient();
                patient.setAppointments(new ArrayList<>());
                patient.setMemberships(new ArrayList<>());
                appointment.setPatient(patient);

                resInvoice invoice = appointment.getInvoice();
                if(invoice !=null){
                    invoice.setAppointment(null);
                    resPackageMembership membership= invoice.getUsedMembership();
                    membership.setPatient(null);
                    resPackageBase packageBase = membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);
                    invoice.setUsedMembership(membership);

                    appointment.setInvoice(invoice);
                }

                appointments.add(appointment);
            });
            doctor.setAppointments(appointments);
            jsonDoctors.add(doctor);
        });

        return jsonDoctors;
    }

    @Override
    public resDoctor getDoctorById(long code) {
        resDoctor doctor = servDoctor.getDoctorByCode(code);
        List<resAppointment> appointments = new ArrayList<>();
        doctor.getAppointments().forEach(appointment -> {
            appointment.setDoctor(null);
            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            appointment.setPatient(patient);

            resInvoice invoice = appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership= invoice.getUsedMembership();
                membership.setPatient(null);
                resPackageBase packageBase = membership.getPackageBase();
                packageBase.setMemberships(new ArrayList<>());
                membership.setPackageBase(packageBase);
                invoice.setUsedMembership(membership);

                appointment.setInvoice(invoice);
            }

            appointments.add(appointment);
        });
        doctor.setAppointments(appointments);
        return doctor;
        //return servDoctor.getDoctorByCode(code);
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
