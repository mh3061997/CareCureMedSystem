package com.carecure.medsysten.services;

import com.carecure.medsysten.interfaces.doctorReservedTimes;
import com.carecure.medsysten.repositories.repoAppointment;
import com.carecure.medsysten.resources.resAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Service
public class servAppointment {

    @Autowired
    repoAppointment repoAppointment;

    //return all appointements in db
    public List<resAppointment> getAppointmentAll(){
        List<resAppointment> AppointmentList = new ArrayList<>();
        repoAppointment.findAll().forEach(AppointmentList::add);
        return AppointmentList;
    }

    public List<resAppointment> getAppointmentPatientDoctor(long patientCode,long doctorCode){
        List<resAppointment> AppointmentList = new ArrayList<>();
        repoAppointment.findByPatientCodeAndDoctorCode(patientCode,doctorCode).forEach(AppointmentList::add);
        return AppointmentList;
    }

    public List<resAppointment> getPastAppointments() throws ParseException {
        List<resAppointment> AppointmentList = new ArrayList<>();
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=ts;
        repoAppointment.findByDateToVisitLessThan(date).forEach(AppointmentList::add);
        return AppointmentList;
    }

    public List<resAppointment> getPastAppointmentsDoctor(long doctorCode) throws ParseException {
        List<resAppointment> AppointmentList = new ArrayList<>();
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=ts;
        repoAppointment.findByDateToVisitLessThanAndDoctorCode(date,doctorCode).forEach(AppointmentList::add);
        return AppointmentList;
    }

    public List<resAppointment> getPastAppointmentsPatient(long patientCode) throws ParseException {
        List<resAppointment> AppointmentList = new ArrayList<>();
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=ts;
        repoAppointment.findByDateToVisitLessThanAndPatientCode(date,patientCode).forEach(AppointmentList::add);
        return AppointmentList;
    }
    public List<resAppointment> getUpcomingAppointments()  {
        List<resAppointment> AppointmentList = new ArrayList<>();
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=ts;
        repoAppointment.findByDateToVisitGreaterThanEqual(date).forEach(AppointmentList::add);
        return AppointmentList;
    }

    public List<resAppointment> getDoctorAppointmentsByDate(String date,long doctorCode) throws ParseException {
        List<resAppointment> AppointmentList = new ArrayList<>();
        Date dateObj = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        System.out.println(dateObj);
        repoAppointment.findByDateToVisitAndDoctorCode(date,doctorCode).forEach(AppointmentList::add);
        return AppointmentList;
    }

    public List<resAppointment> getUpcomingAppointmentsDoctor(long doctorCode)  {
        List<resAppointment> AppointmentList = new ArrayList<>();
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=ts;
        repoAppointment.findByDateToVisitGreaterThanEqualAndDoctorCode(date,doctorCode).forEach(AppointmentList::add);
        return AppointmentList;
    }

    public List<resAppointment> getUpcomingAppointmentsPatient(long patientCode) throws ParseException {
        List<resAppointment> AppointmentList = new ArrayList<>();
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Date date=ts;
        repoAppointment.findByDateToVisitGreaterThanEqualAndPatientCode(date,patientCode).forEach(AppointmentList::add);
        return AppointmentList;
    }
    //return app by id
    public resAppointment getAppointmentByCode(long code){
        Optional<resAppointment> appointment = repoAppointment.findById(code);
        if(appointment.isPresent())
            return appointment.get();
        else
            //throw exception
            return null;
    }

    public void  addAppointment(resAppointment newAppointment){
        repoAppointment.save(newAppointment);
    }

    public void updateAppointment(long appointmentCode, resAppointment updatedAppointment){
        Optional<resAppointment> appointment = repoAppointment.findById(appointmentCode);
        if(appointment.isPresent()){
            updatedAppointment.setCode(appointmentCode);
            repoAppointment.save(updatedAppointment);
        }
    }

    public void deleteAppointment(long code){

        Optional<resAppointment> appointment = repoAppointment.findById(code);
        if(appointment.isPresent())
            repoAppointment.deleteById(code);
        else
            //throw exception
            return;
    }

    public List<doctorReservedTimes> getDoctorReservedTimesByDate(long code,String date){
        List<doctorReservedTimes> doctorReservedTimes = new ArrayList<>();
        repoAppointment.findDoctorReservedTimesByDate(code,date).forEach(doctorReservedTimes::add);
        return doctorReservedTimes;
    }
}
