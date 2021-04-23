package com.carecure.medsysten.controllers;

import com.carecure.medsysten.emailUtils.servEmail;
import com.carecure.medsysten.interfaces.contIntInvoice;
import com.carecure.medsysten.resources.*;
import com.carecure.medsysten.services.servInvoice;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lowagie.text.DocumentException;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.*;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.*;
import java.util.*;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xhtmlrenderer.pdf.ITextRenderer;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@CrossOrigin
@RestController

public class implInvoice implements contIntInvoice {

    @Autowired
    private servInvoice servInvoice;

    @Autowired
    private com.carecure.medsysten.emailUtils.servEmail servEmail;

//    @Autowired
//    SpringTemplateEngine templateEngine;

    @Autowired
    private JavaMailSender sender;



    @Qualifier("getFreeMarkerConfiguration")
    @Autowired
    private Configuration freemarkerConfig;

    @Override
    public List<resInvoice> getInvoiceAll() {
        List<resInvoice> jsonInvoice = new ArrayList<>();
        servInvoice.getInvoiceAll().forEach(invoice -> {


            resAppointment appointment = invoice.getAppointment();
            if (appointment != null) {
                resDoctor doctor = appointment.getDoctor();
                doctor.setAppointments(new ArrayList<>());

                appointment.setDoctor(doctor);

                resPatient patient = appointment.getPatient();
                patient.setMemberships(new ArrayList<>());
                patient.setAppointments(new ArrayList<>());
                patient.setMedImages(new ArrayList<>());
                appointment.setPatient(patient);
                appointment.setInvoice(null);
                invoice.setAppointment(appointment);
            }

            resPackageMembership membership = invoice.getUsedMembership();
            if (membership != null) {

                membership.setPatient(null);


                resPackageBase packageBase = membership.getPackageBase();
                packageBase.setMemberships(new ArrayList<>());
                invoice.setUsedMembership(membership);
            }

            jsonInvoice.add(invoice);
        });

        return jsonInvoice;

    }

    @Override
    public List<resInvoice> getInvoicesByDate(String date) {
        List<resInvoice> jsonInvoice = new ArrayList<>();
        servInvoice.getInvoicesByDate(date).forEach(invoice -> {


            resAppointment appointment = invoice.getAppointment();
            if (appointment != null) {
                resDoctor doctor = appointment.getDoctor();
                doctor.setAppointments(new ArrayList<>());

                appointment.setDoctor(doctor);

                resPatient patient = appointment.getPatient();
                patient.setMemberships(new ArrayList<>());
                patient.setAppointments(new ArrayList<>());
                patient.setMedImages(new ArrayList<>());
                appointment.setPatient(patient);
                appointment.setInvoice(null);
                invoice.setAppointment(appointment);
            }

            resPackageMembership membership = invoice.getUsedMembership();
            if (membership != null) {

                membership.setPatient(null);


                resPackageBase packageBase = membership.getPackageBase();
                packageBase.setMemberships(new ArrayList<>());
                invoice.setUsedMembership(membership);
            }

            jsonInvoice.add(invoice);
        });

        return jsonInvoice;

    }

    @Override
    public resInvoice getInvoiceById(long code) {

        resInvoice invoice = servInvoice.getInvoiceByCode(code);
        resAppointment appointment = invoice.getAppointment();
        if (appointment != null) {
            resDoctor doctor = appointment.getDoctor();
            doctor.setAppointments(new ArrayList<>());

        appointment.setDoctor(doctor);

            resPatient patient = appointment.getPatient();
            patient.setMemberships(new ArrayList<>());
            patient.setAppointments(new ArrayList<>());
            patient.setMedImages(new ArrayList<>());
            appointment.setPatient(patient);
            appointment.setInvoice(null);
            invoice.setAppointment(appointment);
        }

        resPackageMembership membership = invoice.getUsedMembership();
        if (membership != null) {

            membership.setPatient(null);


            resPackageBase packageBase = membership.getPackageBase();
            packageBase.setMemberships(new ArrayList<>());
            invoice.setUsedMembership(membership);
        }

        return invoice;
    }

    @Override
    public resInvoice addInvoice(resInvoice newInvoice) {
        return servInvoice.addInvoice(newInvoice);
    }

    @Override
    public void updateInvoice(long code, resInvoice updatedInvoice) {
        servInvoice.updateInvoice(code, updatedInvoice);
    }

    @Override
    public void deleteInvoice(long code) {
        servInvoice.deleteInvoice(code);
    }

    @Override
    public void sendEmail(resInvoice invoice) throws MessagingException, IOException, TemplateException, DocumentException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Template templateHtml = freemarkerConfig.getTemplate("invoiceTemplateHtml.ftl");
        Template templatePdf = freemarkerConfig.getTemplate("invoiceTemplatePdf.ftl");


        Map<String, Object> model = new HashMap<String, Object>();
        model.put("invoice",invoice);
        model.put("code", invoice.getCode());
        model.put("discount",invoice.getDiscount());
        model.put("dateCreated", invoice.getDateCreated().toString());



        String html = FreeMarkerTemplateUtils.processTemplateIntoString(templateHtml, model);
        String pdf = FreeMarkerTemplateUtils.processTemplateIntoString(templatePdf, model);

        helper.setTo(new String[]{"mhaitham@sumerge.com", "iuseitforhacking@gmail.com"});
        helper.setText(html, true);
        helper.setSubject("Thymeleaf Test Email");

        //OutputStream outputStream = new FileOutputStream("invoice.pdf");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(pdf);
        renderer.layout();
        renderer.createPDF(outputStream);

        ByteInputStream inputStream = new ByteInputStream(outputStream.toByteArray(),outputStream.toByteArray().length);
        helper.addAttachment("invoice.pdf",new ByteArrayResource(inputStream.getBytes()));

        outputStream.close();
        inputStream.close();

        sender.send(message);
    }
}
