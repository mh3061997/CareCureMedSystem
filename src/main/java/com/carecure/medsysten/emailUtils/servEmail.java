package com.carecure.medsysten.emailUtils;
import com.carecure.medsysten.resources.Utils.resContactAppointmentData;
import com.carecure.medsysten.resources.Utils.resContactUsData;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;

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
           helper.setSubject("Contact Patient");

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
            helper.setSubject("Contact Patient");

            sender.send(message);

        }catch (Exception e){

            System.out.println("Exception Thrown "+ e.getMessage());
        }

    }
}
