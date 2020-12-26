package com.carecure.medsysten.services;


import com.carecure.medsysten.repositories.repoDoctor;
import com.carecure.medsysten.resources.resDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servDoctor {

    @Autowired
    repoDoctor repoDoctor;

    //return all doctors in db
    public List<resDoctor> getDoctorAll(){
        List<resDoctor> DoctorList = new ArrayList<>();
        repoDoctor.findAll().forEach(DoctorList::add);
        return DoctorList;
    }

    //return app by id
    public resDoctor getDoctorByCode(long code){
        Optional<resDoctor> doctor = repoDoctor.findById(code);
        if(doctor.isPresent())
            return doctor.get();
        else
            //throw exception
            return null;
    }

    public void  addDoctor(resDoctor newDoctor){
        repoDoctor.save(newDoctor);
    }

    public void updateDoctor(long doctorCode, resDoctor updatedDoctor){
        Optional<resDoctor> doctor = repoDoctor.findById(doctorCode);
        if(doctor.isPresent()){
            updatedDoctor.setCode(doctorCode);
            repoDoctor.save(updatedDoctor);
        }
    }

    public void deleteDoctor(long code){

        Optional<resDoctor> doctor = repoDoctor.findById(code);
        if(doctor.isPresent())
            repoDoctor.deleteById(code);
        else
            //throw exception
            return;
    }

}
