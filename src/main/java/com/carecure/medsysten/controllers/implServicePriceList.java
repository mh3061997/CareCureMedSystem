package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntServicePriceList;
import com.carecure.medsysten.resources.resServicePriceList;
import com.carecure.medsysten.services.servServicePriceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class implServicePriceList implements contIntServicePriceList {

    @Autowired
    private servServicePriceList servServicePriceList;


    @Override
    public List<resServicePriceList> getServicePriceListAll() {
        return servServicePriceList.getServicePriceListAll();
    }

    @Override
    public List<resServicePriceList> getServicePriceListBySpeciality(String speciality) {
        return servServicePriceList.getServicePriceListBySpeciality(speciality);
    }

    @Override
    public void addServicePriceList(resServicePriceList newServicePriceList) {
        servServicePriceList.addServicePriceList(newServicePriceList);
    }

    @Override
    public void updateServicePriceList(long code, resServicePriceList updatedServicePriceList) {
        servServicePriceList.updateServicePriceList(code,updatedServicePriceList);
    }

    @Override
    public void deleteServicePriceList(long code) {
        servServicePriceList.deleteServicePriceList(code);
    }
}
