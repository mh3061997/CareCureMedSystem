package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntAppointment;
import com.carecure.medsysten.interfaces.doctorReservedTimes;
import com.carecure.medsysten.resources.*;
import com.carecure.medsysten.services.servAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
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
             patient.setMedImages(new ArrayList<>());

             resDoctor doctor = appointment.getDoctor();
             doctor.setAppointments(new ArrayList<>());

             appointment.setPatient(patient);
             appointment.setDoctor(doctor);

             resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

             jsonAppointments.add(appointment);

         });
         return jsonAppointments;
    }

    @Override
    public resAppointment getAppointmentById(long code) {

        resAppointment appointment =  servAppointment.getAppointmentByCode(code);

        resPatient patient = appointment.getPatient();
        patient.setAppointments(new ArrayList<>());

        //
        List<resPackageMembership> memberships = new ArrayList<>();
        patient.getMemberships().forEach(membership->{
            resPackageBase packageBase = membership.getPackageBase();
            packageBase.setMemberships(new ArrayList<>());
            membership.setPackageBase(packageBase);
            membership.setPatient(null);
            memberships.add(membership);
        });
        patient.setMemberships(memberships);
        //
        patient.setMedImages(new ArrayList<>());

        resDoctor doctor = appointment.getDoctor();
        doctor.setAppointments(new ArrayList<>());

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        resInvoice invoice =appointment.getInvoice();
        if(invoice !=null){
            invoice.setAppointment(null);
            resPackageMembership membership = invoice.getUsedMembership();
            if(membership!=null){
                membership.setPatient(null);
                resPackageBase packageBase =membership.getPackageBase();
                packageBase.setMemberships(new ArrayList<>());
                membership.setPackageBase(packageBase);

                invoice.setUsedMembership(membership);
            }

            appointment.setInvoice(invoice);
        }


        return appointment;
    }


    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<resAppointment> getPastAppointments() throws ParseException {
        List<resAppointment> jsonAppointments = new ArrayList<>();
        servAppointment.getPastAppointments().forEach(appointment -> {



            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());

            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

            jsonAppointments.add(appointment);

        });
        return jsonAppointments;
    }

    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<resAppointment> getUpcomingAppointments() {
        List<resAppointment> jsonAppointments = new ArrayList<>();
        servAppointment.getUpcomingAppointments().forEach(appointment -> {



            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());

            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

            jsonAppointments.add(appointment);

        });
        return jsonAppointments;
    }

    @Override
    public List<resAppointment> getUpcomingAppointmentsDoctor(long doctorCode) {
        List<resAppointment> jsonAppointments = new ArrayList<>();
        servAppointment.getUpcomingAppointmentsDoctor(doctorCode).forEach(appointment -> {



            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());

            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

            jsonAppointments.add(appointment);

        });
        return jsonAppointments;
    }

    @Override
    public List<resAppointment> getPastAppointmentsDoctor(long doctorCode) throws ParseException {
        List<resAppointment> jsonAppointments = new ArrayList<>();
        servAppointment.getPastAppointmentsDoctor(doctorCode).forEach(appointment -> {



            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());

            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

            jsonAppointments.add(appointment);

        });
        return jsonAppointments;
    }


    @Override
    public List<resAppointment> getPastAppointmentsPatient(long patientCode) throws ParseException {
        List<resAppointment> jsonAppointments = new ArrayList<>();
        servAppointment.getPastAppointmentsPatient(patientCode).forEach(appointment -> {



            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());

            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

            jsonAppointments.add(appointment);

        });
        return jsonAppointments;
    }

    @Override
    public List<resAppointment> getUpcomingAppointmentsPatient(long patientCode) throws ParseException {
        List<resAppointment> jsonAppointments = new ArrayList<>();
        servAppointment.getUpcomingAppointmentsPatient(patientCode).forEach(appointment -> {



            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());

            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

            jsonAppointments.add(appointment);

        });
        return jsonAppointments;
    }

    @Override
    public List<resAppointment> getDoctorAppointmentsByDate(String date) throws ParseException {
        List<resAppointment> jsonAppointments = new ArrayList<>();
        servAppointment.getAppointmentsByDate(date).forEach(appointment -> {


            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());

            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

            jsonAppointments.add(appointment);

        });
        return jsonAppointments;
    }

    @Override
    public List<resAppointment> getDoctorAppointmentsByDate(String date, long doctorCode) throws ParseException {
        List<resAppointment> jsonAppointments = new ArrayList<>();
        servAppointment.getDoctorAppointmentsByDate(date,doctorCode).forEach(appointment -> {



            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());

            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

            jsonAppointments.add(appointment);

        });
        return jsonAppointments;
    }

    @Override
    public List<resAppointment> getAppointmentPatientDoctor(long patientCode,long doctorCode) {
//        System.out.println(patientName+doctorName);
        List<resAppointment> jsonAppointments = new ArrayList<>();
        servAppointment.getAppointmentPatientDoctor(patientCode,doctorCode).forEach(appointment -> {


            resPatient patient = appointment.getPatient();
            patient.setAppointments(new ArrayList<>());
            patient.setMemberships(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());

            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

            appointment.setPatient(patient);
            appointment.setDoctor(doctor);

            resInvoice invoice =appointment.getInvoice();
            if(invoice !=null){
                invoice.setAppointment(null);
                resPackageMembership membership = invoice.getUsedMembership();
                if(membership!=null){
                    membership.setPatient(null);
                    resPackageBase packageBase =membership.getPackageBase();
                    packageBase.setMemberships(new ArrayList<>());
                    membership.setPackageBase(packageBase);

                    invoice.setUsedMembership(membership);
                }

                appointment.setInvoice(invoice);
            }

            jsonAppointments.add(appointment);

        });
        return jsonAppointments;
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
