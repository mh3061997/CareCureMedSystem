package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntPackageBase;
import com.carecure.medsysten.resources.resPackageBase;
import com.carecure.medsysten.resources.resPackageMembership;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.services.servPackageBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class implPackageBase implements contIntPackageBase {

    @Autowired
    private servPackageBase servPackageBase;


    @Override
    public List<resPackageBase> getPackageBaseAllByStatus(String status) {
        List<resPackageBase> packages = new ArrayList<>();

        servPackageBase.getPackageBaseByStatus(status).forEach(packageBase ->{

            List<resPackageMembership> memberships = packageBase.getMemberships();
            memberships.forEach(membership ->{
                membership.setPackageBase(null);
                resPatient patient =  membership.getPatient();
                patient.setMemberships(new ArrayList<>());
                patient.setAppointments(new ArrayList<>());
                membership.setPatient(patient);
            });
            packageBase.setMemberships(memberships);

            packages.add(packageBase);
        });
        return packages;
    }

    @Override
    public List<resPackageBase> getPackageBaseAll() {
        List<resPackageBase> packages = new ArrayList<>();

         servPackageBase.getPackageBaseAll().forEach(packageBase ->{

             List<resPackageMembership> memberships = packageBase.getMemberships();
             memberships.forEach(membership ->{
                 membership.setPackageBase(null);
                 resPatient patient =  membership.getPatient();
                 patient.setMemberships(new ArrayList<>());
                 patient.setAppointments(new ArrayList<>());
                 membership.setPatient(patient);
             });
             packageBase.setMemberships(memberships);

             packages.add(packageBase);
         });
         return packages;
    }

    @Override
    public resPackageBase getPackageBaseById(long code) {

        resPackageBase packageBase =  servPackageBase.getPackageBaseByCode(code);
        List<resPackageMembership> memberships = packageBase.getMemberships();
        memberships.forEach(membership ->{
            membership.setPackageBase(null);
            resPatient patient =  membership.getPatient();
            patient.setMemberships(new ArrayList<>());
            patient.setAppointments(new ArrayList<>());
            membership.setPatient(patient);
        });
        packageBase.setMemberships(memberships);
        return packageBase;
    }

    @Override
    public void addPackageBase(resPackageBase newPackageBase) {
        servPackageBase.addPackageBase(newPackageBase);
    }

    @Override
    public void updatePackageBase(long code, resPackageBase updatedPackageBase) {
        servPackageBase.updatePackageBase(code,updatedPackageBase);
    }

    @Override
    public void deletePackageBase(long code) {
        servPackageBase.deletePackageBase(code);
    }
}
