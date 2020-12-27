package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntPackageMembership;
import com.carecure.medsysten.resources.resPackageMembership;
import com.carecure.medsysten.services.servPackageMembership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class implPackageMembership implements contIntPackageMembership {

    @Autowired
    private servPackageMembership servPackageMembership;


    @Override
    public List<resPackageMembership> getPackageMembershipAll() {
        return servPackageMembership.getPackageMembershipAll();
    }

    @Override
    public resPackageMembership getPackageMembershipById(long code) {
        return servPackageMembership.getPackageMembershipByCode(code);
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
