package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntPatient;
import com.carecure.medsysten.resources.*;
import com.carecure.medsysten.services.servPatient;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class implPatient implements contIntPatient {

    @Autowired
    private servPatient servPatient;


    @Override
    public List<resPatient> getPatientAll() {
        List<resPatient> jsonPatients = new ArrayList<>();

        servPatient.getPatientAll().forEach(patient -> {

            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());
            patient.setInvoiceMemberships(new ArrayList<>());

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
            doctor.setAvailableDays(new ArrayList<>());
            appointment.setDoctor(doctor);

            resInvoice invoice = appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
               if(membership!=null){
                   membership.setPatient(null);
                   resPackageBase packageBase = membership.getPackageBase();
                   packageBase.setMemberships(new ArrayList<>());
                   membership.setPackageBase(packageBase);
                   invoice.setUsedMembership(membership);
               }
               invoice.setInvoiceItems(new ArrayList<>());
                appointment.setInvoice(invoice);
            }
            appointments.add(appointment);
        });
        patient.setAppointments(appointments);

        List<resInvoice> invoiceMemberships = new ArrayList<>();
        patient.getInvoiceMemberships().forEach(invoice -> {
            invoice.setAppointment(null);
            invoice.setPatientMembershipSubscriber(null);
            resPackageMembership membership = invoice.getUsedMembership();
            if(membership!=null){
                membership.setPatient(null);
                resPackageBase packageBase = membership.getPackageBase();
                packageBase.setMemberships(new ArrayList<>());
                membership.setPackageBase(packageBase);
                invoice.setUsedMembership(membership);
            }
            invoiceMemberships.add(invoice);
        });
        patient.setInvoiceMemberships(invoiceMemberships);

        List<resPackageMembership> jsons = new ArrayList<>();
        List<resPackageMembership> memberships = patient.getMemberships();
        memberships.forEach(membership->{
            membership.setPatient(null);
            resPackageBase packageBase = membership.getPackageBase();
            packageBase.setMemberships(new ArrayList<>());
            jsons.add(membership);
        });
        patient.setMemberships(jsons);


        return patient;
        //return servPatient.getPatientByCode(code);
    }

    @Override
    public resPatient addPatient(resPatient newPatient) {
        return servPatient.addPatient(newPatient);
    }

    @Override
    public void updatePatient(long code, resPatient updatedPatient) {
        servPatient.updatePatient(code,updatedPatient);
    }

    @Override
    public void deletePatient(long code) {
        servPatient.deletePatient(code);
    }

    @Override
    public void settlePatientDebt(long code, long debtDeducted){
    servPatient.settlePatientDebt(code,debtDeducted);
    }
}
