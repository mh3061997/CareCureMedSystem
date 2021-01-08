package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntInvoice;
import com.carecure.medsysten.resources.*;
import com.carecure.medsysten.services.servInvoice;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController

public class implInvoice implements contIntInvoice {

    @Autowired
    private servInvoice servInvoice;


    @Override
    public List<resInvoice> getInvoiceAll() {
        List<resInvoice> jsonInvoice = new ArrayList<>();
       servInvoice.getInvoiceAll().forEach(invoice ->{


           resAppointment appointment = invoice.getAppointment();
           resDoctor doctor = appointment.getDoctor();
           doctor.setAppointments(new ArrayList<>());

           appointment.setDoctor(doctor);

           resPatient patient =appointment.getPatient();
           patient.setMemberships(new ArrayList<>());
           patient.setAppointments(new ArrayList<>());
           patient.setMedImages(new ArrayList<>());
           appointment.setPatient(patient);
           appointment.setInvoice(null);
           invoice.setAppointment(appointment);

           resPackageMembership membership = invoice.getUsedMembership();
           if(membership!=null){

               membership.setPatient(null);


               resPackageBase  packageBase = membership.getPackageBase();
               packageBase.setMemberships(new ArrayList<>());
               invoice.setUsedMembership(membership);
           }

          jsonInvoice.add(invoice);
       });

       return jsonInvoice;

    }

    @Override
    public resInvoice getInvoiceById(long code) {

        resInvoice invoice =  servInvoice.getInvoiceByCode(code);
        resAppointment appointment = invoice.getAppointment();
        resDoctor doctor = appointment.getDoctor();
        doctor.setAppointments(new ArrayList<>());

        appointment.setDoctor(doctor);

        resPatient patient =appointment.getPatient();
        patient.setMemberships(new ArrayList<>());
        patient.setAppointments(new ArrayList<>());
        patient.setMedImages(new ArrayList<>());
        appointment.setPatient(patient);
        appointment.setInvoice(null);
        invoice.setAppointment(appointment);

        resPackageMembership membership = invoice.getUsedMembership();
        if(membership!=null){

            membership.setPatient(null);


            resPackageBase  packageBase = membership.getPackageBase();
            packageBase.setMemberships(new ArrayList<>());
            invoice.setUsedMembership(membership);
        }

        return invoice;
    }

    @Override
    public void addInvoice(resInvoice newInvoice) {
        servInvoice.addInvoice(newInvoice);
    }

    @Override
    public void updateInvoice(long code, resInvoice updatedInvoice) {
        servInvoice.updateInvoice(code,updatedInvoice);
    }

    @Override
    public void deleteInvoice(long code) {
        servInvoice.deleteInvoice(code);
    }
}
