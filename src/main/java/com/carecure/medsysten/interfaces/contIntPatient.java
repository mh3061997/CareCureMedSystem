package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resPatient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/patient")
public interface contIntPatient {

    @RequestMapping
    List<resPatient> getPatientAll();

    @RequestMapping("/{patientCode}")
    resPatient getPatientById(@PathVariable("patientCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addPatient(@RequestBody resPatient newPatient);

    @RequestMapping(method = RequestMethod.PUT,value="/{patientCode}")
    void updatePatient(@PathVariable("patientCode") long code, @RequestBody resPatient updatedPatient);

    @RequestMapping(method = RequestMethod.PUT,value="/{patientCode}/debt/{debtDeducted}")
    void settlePatientDebt(@PathVariable("patientCode") long code, @PathVariable("debtDeducted") long debtDeducted);

    @RequestMapping(method= RequestMethod.DELETE,value="/{patientCode}")
    void deletePatient(@PathVariable("patientCode") long code);
}
