package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resMedImage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/medImage")
public interface contIntMedImage {

    @RequestMapping
    List<resMedImage> getMedImageAll();

    @RequestMapping("/{medImageCode}")
    resMedImage getMedImageById(@PathVariable("medImageCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addMedImage(@RequestBody resMedImage newMedImage);

    @RequestMapping(method = RequestMethod.PUT,value="/{medImageCode}")
    void updateMedImage(@PathVariable("medImageCode") long code, @RequestBody resMedImage updatedMedImage);

    @RequestMapping(method= RequestMethod.DELETE,value="/{medImageCode}")
    void deleteMedImage(@PathVariable("medImageCode") long code);
}
