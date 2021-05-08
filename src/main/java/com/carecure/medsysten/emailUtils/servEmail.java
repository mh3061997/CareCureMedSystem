package com.carecure.medsysten.emailUtils;
import com.carecure.medsysten.resources.Utils.resContactAppointmentData;
import com.carecure.medsysten.resources.Utils.resContactUsData;
import com.carecure.medsysten.resources.resAppointment;
import com.carecure.medsysten.resources.resInvoice;
import com.lowagie.text.DocumentException;
import com.sun.xml.messaging.saaj.util.ByteInputStream;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.sun.xml.messaging.saaj.util.ByteInputStream;
import freemarker.template.Template;
import org.springframework.core.io.*;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class servEmail {



    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private JavaMailSender sender;



    @Qualifier("getFreeMarkerConfiguration")
    @Autowired
    private Configuration freemarkerConfig;

    public void sendContactUsEmail(resContactUsData contactUsData) throws MessagingException, IOException
    {

       try{
           MimeMessage message = sender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(message,
                   MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                   StandardCharsets.UTF_8.name());

           Template templateHtml = freemarkerConfig.getTemplate("contactUsTemplateHtml.ftl");

           Map<String, Object> model = new HashMap<String, Object>();
           model.put("name",contactUsData.getName());
           model.put("mobile", contactUsData.getMobile());
           model.put("email",contactUsData.getEmail());
           model.put("message", contactUsData.getMessage());



           String html = FreeMarkerTemplateUtils.processTemplateIntoString(templateHtml, model);

           helper.setTo(new String[]{"iuseitforhacking@gmail.com"});
           helper.setText(html, true);
           helper.setSubject("System - Contact Patient");

           sender.send(message);

       }catch (Exception e){

           System.out.println("Exception Thrown "+ e.getMessage());
       }



    }

    public void sendContactAppointmentEmail(resContactAppointmentData contactAppointmentData) {

        try{
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Template templateHtml = freemarkerConfig.getTemplate("contactAppointmentTemplateHtml.ftl");

            Map<String, Object> model = new HashMap<String, Object>();
            model.put("name",contactAppointmentData.getName());
            model.put("mobile", contactAppointmentData.getMobile());
            model.put("speciality",contactAppointmentData.getSpeciality());
            model.put("doctorName", contactAppointmentData.getDoctorName());



            String html = FreeMarkerTemplateUtils.processTemplateIntoString(templateHtml, model);

            helper.setTo(new String[]{"iuseitforhacking@gmail.com"});
            helper.setText(html, true);
            helper.setSubject("System - Contact for Appointment ");

            sender.send(message);

        }catch (Exception e){

            System.out.println("Exception Thrown "+ e.getMessage());
        }

    }
    public void sendAppointmentConfirmationEmail(resAppointment appointment) {

        try{
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());

            Template templateHtml = freemarkerConfig.getTemplate("appointmentConfirmationTemplateHtml.ftl");

            Map<String, Object> model = new HashMap<String, Object>();
            model.put("patientName",appointment.getPatient().getName());
            model.put("doctorName",appointment.getDoctor().getName());
            model.put("speciality",appointment.getSpeciality());
            model.put("dateTime",appointment.getDateToVisit());

            if (appointment.getType().equals("Visit"))
            model.put("type"," ");
            else
            model.put("type"," follow up ");





            String html = FreeMarkerTemplateUtils.processTemplateIntoString(templateHtml, model);

            helper.setTo(new String[]{appointment.getPatient().getEmail()});
            helper.setText(html, true);
            helper.setSubject("Appointment Confirmation");

            sender.send(message);

        }catch (Exception e){

            System.out.println("Exception Thrown "+ e.getMessage());
        }

    }

    public void sendInvoiceEmail(resInvoice invoice) throws MessagingException, DocumentException, IOException, TemplateException
    {
        try {
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

        helper.setTo(new String[]{"iuseitforhacking@gmail.com"});
        helper.setText(html, true);
        helper.setSubject("Appointment Invoice");

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
        }catch (Exception e){

            System.out.println("Exception Thrown "+ e.getMessage());
        }
    }
}
