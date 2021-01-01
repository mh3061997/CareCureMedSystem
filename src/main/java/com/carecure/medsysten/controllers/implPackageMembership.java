package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntPackageMembership;
import com.carecure.medsysten.resources.resPackageBase;
import com.carecure.medsysten.resources.resPackageMembership;
import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.services.servPackageMembership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class implPackageMembership implements contIntPackageMembership {

    @Autowired
    private servPackageMembership servPackageMembership;


    @Override
    public List<resPackageMembership> getPackageMembershipAll() {
        List<resPackageMembership> memberships = new ArrayList<>();

        servPackageMembership.getPackageMembershipAll().forEach(membership ->{

            resPackageBase packageBase = membership.getPackageBase();
            packageBase.setMemberships(new ArrayList<>());
            membership.setPackageBase(packageBase);

            resPatient patient = membership.getPatient();

            patient.setMemberships(new ArrayList<>());
            patient.setAppointments(new ArrayList<>());

            membership.setPatient(patient);
            memberships.add(membership);

        });

        return memberships;
    }

    @Override
    public resPackageMembership getPackageMembershipById(long code) {
        resPackageMembership membership =  servPackageMembership.getPackageMembershipByCode(code);
        resPackageBase packageBase = membership.getPackageBase();
        packageBase.setMemberships(new ArrayList<>());
        membership.setPackageBase(packageBase);

        resPatient patient = membership.getPatient();

        patient.setMemberships(new ArrayList<>());
        patient.setAppointments(new ArrayList<>());
        membership.setPatient(patient);

        return membership;
    }

    @Override
    public void addPackageMembership(resPackageMembership newPackageMembership) {
        servPackageMembership.addPackageMembership(newPackageMembership);
    }

    @Override
    public void updatePackageMembership(long code, resPackageMembership updatedPackageMembership) {
        servPackageMembership.updatePackageMembership(code,updatedPackageMembership);
    }

    @Override
    public void deletePackageMembership(long code) {
        servPackageMembership.deletePackageMembership(code);
    }
}
