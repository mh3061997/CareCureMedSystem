package com.carecure.medsysten.services;

import com.carecure.medsysten.repositories.repoServicePriceList;
import com.carecure.medsysten.resources.resServicePriceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servServicePriceList {

    @Autowired
    repoServicePriceList repoServicePriceList;

    //return all servicePriceLists in db
    public List<resServicePriceList> getServicePriceListAll(){
        List<resServicePriceList> ServicePriceListList = new ArrayList<>();
        repoServicePriceList.findAll().forEach(ServicePriceListList::add);
        return ServicePriceListList;
    }

    public List<resServicePriceList> getServicePriceListBySpeciality(String speciality){
        List<resServicePriceList> ServicePriceListList = new ArrayList<>();
        repoServicePriceList.findBySpeciality(speciality).forEach(ServicePriceListList::add);
        return ServicePriceListList;
    }

    public void  addServicePriceList(resServicePriceList newServicePriceList){
        repoServicePriceList.save(newServicePriceList);
    }

    public void updateServicePriceList(long servicePriceListCode, resServicePriceList updatedServicePriceList){
        Optional<resServicePriceList> servicePriceList = repoServicePriceList.findById(servicePriceListCode);
        if(servicePriceList.isPresent()){
            updatedServicePriceList.setCode(servicePriceListCode);
            repoServicePriceList.save(updatedServicePriceList);
        }
    }

    public void deleteServicePriceList(long code){

        Optional<resServicePriceList> servicePriceList = repoServicePriceList.findById(code);
        if(servicePriceList.isPresent())
            repoServicePriceList.deleteById(code);
        else
            //throw exception
            return;
    }

}
