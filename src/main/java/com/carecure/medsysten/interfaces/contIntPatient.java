package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resPatient;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/patient")
@Api(tags = "Patient")
public interface contIntPatient {

    @RequestMapping(method = RequestMethod.GET)
    List<resPatient> getPatientAll();

    @RequestMapping(method = RequestMethod.GET,value = "/{patientCode}")
    resPatient getPatientById(@PathVariable("patientCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    resPatient addPatient(@RequestBody resPatient newPatient);

    @RequestMapping(method = RequestMethod.PUT,value="/{patientCode}")
    void updatePatient(@PathVariable("patientCode") long code, @RequestBody resPatient updatedPatient);

    @RequestMapping(method = RequestMethod.PUT,value="/{patientCode}/debt/{debtDeducted}")
    void settlePatientDebt(@PathVariable("patientCode") long code, @PathVariable("debtDeducted") long debtDeducted);

    @RequestMapping(method= RequestMethod.DELETE,value="/{patientCode}")
    void deletePatient(@PathVariable("patientCode") long code);
}
