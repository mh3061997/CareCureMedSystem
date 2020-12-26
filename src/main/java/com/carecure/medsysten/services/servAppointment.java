package com.carecure.medsysten.services;

import com.carecure.medsysten.repositories.repoAppointment;
import com.carecure.medsysten.resources.resAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

}
