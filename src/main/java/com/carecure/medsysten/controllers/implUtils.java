package com.carecure.medsysten.controllers;

import com.carecure.medsysten.emailUtils.servEmail;
import com.carecure.medsysten.interfaces.contIntAppointment;
import com.carecure.medsysten.interfaces.contIntUtils;
import com.carecure.medsysten.resources.Utils.resContactAppointmentData;
import com.carecure.medsysten.resources.Utils.resContactUsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@CrossOrigin
@RestController
public class implUtils implements contIntUtils
{

	@Autowired
	com.carecure.medsysten.emailUtils.servEmail servEmail;
	@Override
	public void sendContactUsEmail(resContactUsData contactUsData) throws IOException, MessagingException
	{
		servEmail.sendContactUsEmail(contactUsData);
	}

	@Override
	public void sendContactAppointmentEmail(resContactAppointmentData contactAppointmentData)
	{
		servEmail.sendContactAppointmentEmail(contactAppointmentData);
	}
}
