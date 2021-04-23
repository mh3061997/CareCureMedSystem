package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.Utils.resContactAppointmentData;
import com.carecure.medsysten.resources.Utils.resContactUsData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.io.IOException;
import java.lang.invoke.MethodType;

@RequestMapping("/utils")
public interface contIntUtils
{

	@RequestMapping(method = RequestMethod.POST,value = "/email-contact-us")
	 void sendContactUsEmail(@RequestBody resContactUsData contactUsData) throws IOException, MessagingException;

	@RequestMapping(method = RequestMethod.POST,value = "/email-contact-appointment")
	void sendContactAppointmentEmail(@RequestBody resContactAppointmentData contactAppointmentData);
}
