
package com.carecure.medsysten.services;

import com.carecure.medsysten.resources.resMedImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servMedImage {

    @Autowired
    com.carecure.medsysten.repositories.repoMedImage repoMedImage;

    //return all medImages in db
    public List<resMedImage> getMedImageAll(){
        List<resMedImage> MedImageList = new ArrayList<>();
        repoMedImage.findAll().forEach(MedImageList::add);
        return MedImageList;
    }

    //return app by id
    public resMedImage getMedImageByCode(long code){
        Optional<resMedImage> medImage = repoMedImage.findById(code);
        if(medImage.isPresent())
            return medImage.get();
        else
            //throw exception
            return null;
    }

    public void  addMedImage(resMedImage newMedImage){
        repoMedImage.save(newMedImage);
    }

    public void updateMedImage(long medImageCode, resMedImage updatedMedImage){
        Optional<resMedImage> medImage = repoMedImage.findById(medImageCode);
        if(medImage.isPresent()){
            updatedMedImage.setCode(medImageCode);
            repoMedImage.save(updatedMedImage);
        }
    }

    public void deleteMedImage(long code){

        Optional<resMedImage> medImage = repoMedImage.findById(code);
        if(medImage.isPresent())
            repoMedImage.deleteById(code);
        else
            //throw exception
            return;
    }

}
