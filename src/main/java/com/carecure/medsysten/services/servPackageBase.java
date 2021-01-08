package com.carecure.medsysten.services;


import com.carecure.medsysten.repositories.repoPackageBase;
import com.carecure.medsysten.resources.resPackageBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servPackageBase {

    @Autowired
    repoPackageBase repoPackageBase;

    //return all packageBases in db
    public List<resPackageBase> getPackageBaseAll(){
        List<resPackageBase> PackageBaseList = new ArrayList<>();
        repoPackageBase.findAll().forEach(PackageBaseList::add);
        return PackageBaseList;
    }

    public List<resPackageBase> getPackageBaseByStatus(String status){
        List<resPackageBase> PackageBaseList = new ArrayList<>();
        repoPackageBase.findByStatus(status).forEach(PackageBaseList::add);
        return PackageBaseList;
    }


    //return app by id
    public resPackageBase getPackageBaseByCode(long code){
        Optional<resPackageBase> packageBase = repoPackageBase.findById(code);
        if(packageBase.isPresent())
            return packageBase.get();
        else
            //throw exception
            return null;
    }

    public void  addPackageBase(resPackageBase newPackageBase){
        repoPackageBase.save(newPackageBase);
    }

    public void updatePackageBase(long packageBaseCode, resPackageBase updatedPackageBase){
        Optional<resPackageBase> packageBase = repoPackageBase.findById(packageBaseCode);
        if(packageBase.isPresent()){
            updatedPackageBase.setCode(packageBaseCode);
            repoPackageBase.save(updatedPackageBase);
        }
    }

    public void deletePackageBase(long code){

        Optional<resPackageBase> packageBase = repoPackageBase.findById(code);
        if(packageBase.isPresent())
            repoPackageBase.deleteById(code);
        else
            //throw exception
            return;
    }

}
