package com.carecure.medsysten.services;


import com.carecure.medsysten.repositories.repoPatient;
import com.carecure.medsysten.resources.resPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servPatient {

    @Autowired
    repoPatient repoPatient;

    //return all patients in db
    public List<resPatient> getPatientAll(){
        List<resPatient> PatientList = new ArrayList<>();
        repoPatient.findAll().forEach(PatientList::add);
        return PatientList;
    }

    //return app by id
    public resPatient getPatientByCode(long code){
        Optional<resPatient> patient = repoPatient.findById(code);
        if(patient.isPresent())
            return patient.get();
        else
            //throw exception
            return null;
    }

    public void  addPatient(resPatient newPatient){
        repoPatient.save(newPatient);
    }

    public void updatePatient(long patientCode, resPatient updatedPatient){
        Optional<resPatient> patient = repoPatient.findById(patientCode);
        if(patient.isPresent()){
            updatedPatient.setCode(patientCode);
            repoPatient.save(updatedPatient);
        }
    }

    public void deletePatient(long code){

        Optional<resPatient> patient = repoPatient.findById(code);
        if(patient.isPresent())
            repoPatient.deleteById(code);
        else
            //throw exception
            return;
    }

}
