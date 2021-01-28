
package com.carecure.medsysten.services;

import com.carecure.medsysten.resources.resDoctorDayAvail;
import com.carecure.medsysten.resources.resDoctorDayAvail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servDoctorDayAvail {

    @Autowired
    com.carecure.medsysten.repositories.repoDoctorDayAvail repoDoctorDayAvail;

    //return all doctorDayAvails in db
    public List<resDoctorDayAvail> getDoctorDayAvailAll(){
        List<resDoctorDayAvail> DoctorDayAvailList = new ArrayList<>();
        repoDoctorDayAvail.findAll().forEach(DoctorDayAvailList::add);
        return DoctorDayAvailList;
    }

    //return app by id
    public resDoctorDayAvail getDoctorDayAvailByCode(long code){
        Optional<resDoctorDayAvail> doctorDayAvail = repoDoctorDayAvail.findById(code);
        if(doctorDayAvail.isPresent())
            return doctorDayAvail.get();
        else
            //throw exception
            return null;
    }

    public void  addDoctorDayAvail(resDoctorDayAvail newDoctorDayAvail){
        repoDoctorDayAvail.save(newDoctorDayAvail);
    }

    public void updateDoctorDayAvail(long doctorDayAvailCode, resDoctorDayAvail updatedDoctorDayAvail){
        Optional<resDoctorDayAvail> doctorDayAvail = repoDoctorDayAvail.findById(doctorDayAvailCode);
        if(doctorDayAvail.isPresent()){
            updatedDoctorDayAvail.setCode(doctorDayAvailCode);
            repoDoctorDayAvail.save(updatedDoctorDayAvail);
        }
    }

    public void addDoctorDayAvailMulti(List<resDoctorDayAvail> newDoctorDayAvailArr) {
        newDoctorDayAvailArr.forEach(doctorDayAvail ->{
            repoDoctorDayAvail.save(doctorDayAvail);
        });
    }


    public void deleteDoctorDayAvail(long code){

        Optional<resDoctorDayAvail> doctorDayAvail = repoDoctorDayAvail.findById(code);
        if(doctorDayAvail.isPresent())
            repoDoctorDayAvail.deleteById(code);
        else
            //throw exception
            return;
    }

}
