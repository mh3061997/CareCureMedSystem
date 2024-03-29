package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntMedImage;
import com.carecure.medsysten.resources.resMedImage;
import com.carecure.medsysten.services.servMedImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class implMedImage implements contIntMedImage
{

	@Autowired
	private servMedImage servMedImage;

	@CrossOrigin
	@Override
	public List<resMedImage> getMedImageAll()
	{
		//		return servMedImage.getMedImageAll();
		return new ArrayList<>();
	}

	@Override
	public resMedImage getMedImageById(long code)
	{
		return servMedImage.getMedImageByCode(code);
	}

	@Override
	public void addMedImage(resMedImage newMedImage)
	{
		servMedImage.addMedImage(newMedImage);
	}

	@Override
	public void updateMedImage(long code, resMedImage updatedMedImage)
	{
		servMedImage.updateMedImage(code, updatedMedImage);
	}

	@Override
	public void deleteMedImage(long code)
	{
		servMedImage.deleteMedImage(code);
	}
}
