package com.carecure.medsysten.controllers;

import com.carecure.medsysten.emailUtils.servEmail;
import com.carecure.medsysten.interfaces.contIntInvoice;
import com.carecure.medsysten.resources.*;
import com.carecure.medsysten.services.servInvoice;
import com.lowagie.text.DocumentException;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import javax.mail.MessagingException;
import java.io.*;
import java.util.*;
import org.springframework.mail.javamail.JavaMailSender;


@CrossOrigin
@RestController

public class implInvoice implements contIntInvoice {

    @Autowired
    private servInvoice servInvoice;

    @Autowired
    private servEmail servEmail;


    @Override
    public List<resInvoice> getInvoiceAll() {
        List<resInvoice> jsonInvoice = new ArrayList<>();
        servInvoice.getInvoiceAll().forEach(invoice -> {


            resAppointment appointment = invoice.getAppointment();
            if (appointment != null) {
                resDoctor doctor = appointment.getDoctor();
                doctor.setAppointments(new ArrayList<>());

                appointment.setDoctor(doctor);

                resPatient patient = appointment.getPatient();
                patient.setMemberships(new ArrayList<>());
                patient.setAppointments(new ArrayList<>());
                patient.setMedImages(new ArrayList<>());
                appointment.setPatient(patient);
                appointment.setInvoice(null);
                invoice.setAppointment(appointment);
            }

            resPackageMembership membership = invoice.getUsedMembership();
            if (membership != null) {

                membership.setPatient(null);


                resPackageBase packageBase = membership.getPackageBase();
                packageBase.setMemberships(new ArrayList<>());
                invoice.setUsedMembership(membership);
            }

            jsonInvoice.add(invoice);
        });

        return jsonInvoice;

    }

    @Override
    public List<resInvoice> getInvoicesByDate(String date) {
        List<resInvoice> jsonInvoice = new ArrayList<>();
        servInvoice.getInvoicesByDate(date).forEach(invoice -> {


            resAppointment appointment = invoice.getAppointment();
            if (appointment != null) {
                resDoctor doctor = appointment.getDoctor();
                doctor.setAppointments(new ArrayList<>());

                appointment.setDoctor(doctor);

                resPatient patient = appointment.getPatient();
                patient.setMemberships(new ArrayList<>());
                patient.setAppointments(new ArrayList<>());
                patient.setMedImages(new ArrayList<>());
                appointment.setPatient(patient);
                appointment.setInvoice(null);
                invoice.setAppointment(appointment);
            }

            resPackageMembership membership = invoice.getUsedMembership();
            if (membership != null) {

                membership.setPatient(null);


                resPackageBase packageBase = membership.getPackageBase();
                packageBase.setMemberships(new ArrayList<>());
                invoice.setUsedMembership(membership);
            }

            jsonInvoice.add(invoice);
        });

        return jsonInvoice;

    }

    @Override
    public resInvoice getInvoiceById(long code) {

        resInvoice invoice = servInvoice.getInvoiceByCode(code);
        resAppointment appointment = invoice.getAppointment();
        if (appointment != null) {
            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setDoctor(doctor);

            resPatient patient = appointment.getPatient();
            patient.setMemberships(new ArrayList<>());
            patient.setAppointments(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());
            appointment.setPatient(patient);
            appointment.setInvoice(null);
            invoice.setAppointment(appointment);
        }

        resPackageMembership membership = invoice.getUsedMembership();
        if (membership != null) {

            membership.setPatient(null);


            resPackageBase packageBase = membership.getPackageBase();
            packageBase.setMemberships(new ArrayList<>());
            invoice.setUsedMembership(membership);
        }

        return invoice;
    }

    @Override
    public resInvoice addInvoice(resInvoice newInvoice) {
        return servInvoice.addInvoice(newInvoice);
    }

    @Override
    public void updateInvoice(long code, resInvoice updatedInvoice) {
        servInvoice.updateInvoice(code, updatedInvoice);
    }

    @Override
    public void deleteInvoice(long code) {
        servInvoice.deleteInvoice(code);
    }

    @Override
    public void sendInvoiceEmail(resInvoice invoice) throws MessagingException, IOException, TemplateException, DocumentException {
        servEmail.sendInvoiceEmail(invoice);
    }
}
