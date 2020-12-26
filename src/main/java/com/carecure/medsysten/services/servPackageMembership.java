package com.carecure.medsysten.services;


import com.carecure.medsysten.repositories.repoPackageMembership;
import com.carecure.medsysten.resources.resPackageMembership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servPackageMembership {

    @Autowired
    repoPackageMembership repoPackageMembership;

    //return all packageMemberships in db
    public List<resPackageMembership> getPackageMembershipAll(){
        List<resPackageMembership> PackageMembershipList = new ArrayList<>();
        repoPackageMembership.findAll().forEach(PackageMembershipList::add);
        return PackageMembershipList;
    }

    //return app by id
    public resPackageMembership getPackageMembershipByCode(long code){
        Optional<resPackageMembership> packageMembership = repoPackageMembership.findById(code);
        if(packageMembership.isPresent())
            return packageMembership.get();
        else
            //throw exception
            return null;
    }

    public void  addPackageMembership(resPackageMembership newPackageMembership){
        repoPackageMembership.save(newPackageMembership);
    }

    public void updatePackageMembership(long packageMembershipCode, resPackageMembership updatedPackageMembership){
        Optional<resPackageMembership> packageMembership = repoPackageMembership.findById(packageMembershipCode);
        if(packageMembership.isPresent()){
            updatedPackageMembership.setCode(packageMembershipCode);
            repoPackageMembership.save(updatedPackageMembership);
        }
    }

    public void deletePackageMembership(long code){

        Optional<resPackageMembership> packageMembership = repoPackageMembership.findById(code);
        if(packageMembership.isPresent())
            repoPackageMembership.deleteById(code);
        else
            //throw exception
            return;
    }

}
