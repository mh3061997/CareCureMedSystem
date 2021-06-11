package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resInvoice;
import com.lowagie.text.DocumentException;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RequestMapping("/invoice")
@Api(tags = "Invoice")
public interface contIntInvoice {

    @RequestMapping(method = RequestMethod.GET)
    List<resInvoice> getInvoiceAll();

    @RequestMapping(method = RequestMethod.GET,value = "/{invoiceCode}")
    resInvoice getInvoiceById(@PathVariable("invoiceCode") long code);

    @RequestMapping(method = RequestMethod.GET,value = "/date")
    List<resInvoice> getInvoicesByDate(@RequestParam("date") String date);

    @RequestMapping(method = RequestMethod.POST)
    resInvoice addInvoice(@RequestBody resInvoice newInvoice);

    @RequestMapping(method = RequestMethod.PUT,value="/{invoiceCode}")
    void updateInvoice(@PathVariable("invoiceCode") long code, @RequestBody resInvoice updatedInvoice);

    @RequestMapping(method= RequestMethod.DELETE,value="/{invoiceCode}")
    void deleteInvoice(@PathVariable("invoiceCode") long code);

    @RequestMapping(method= RequestMethod.POST,value="/email")
    void sendInvoiceEmail(@RequestBody resInvoice invoice) throws IOException, MessagingException, TemplateException, DocumentException;
}
