package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntPackageBase;
import com.carecure.medsysten.resources.resPackageBase;
import com.carecure.medsysten.services.servPackageBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class implPackageBase implements contIntPackageBase {

    @Autowired
    private servPackageBase servPackageBase;


    @Override
    public List<resPackageBase> getPackageBaseAll() {
        return servPackageBase.getPackageBaseAll();
    }

    @Override
    public resPackageBase getPackageBaseById(long code) {
        return servPackageBase.getPackageBaseByCode(code);
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
