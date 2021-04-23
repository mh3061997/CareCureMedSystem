package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resAppointment;
import com.carecure.medsysten.resources.resInvoice;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RequestMapping("/invoice")
public interface contIntInvoice {

    @RequestMapping
    List<resInvoice> getInvoiceAll();

    @RequestMapping("/{invoiceCode}")
    resInvoice getInvoiceById(@PathVariable("invoiceCode") long code);

    @RequestMapping("/date")
    List<resInvoice> getInvoicesByDate(@RequestParam("date") String date);

    @RequestMapping(method = RequestMethod.POST)
    resInvoice addInvoice(@RequestBody resInvoice newInvoice);

    @RequestMapping(method = RequestMethod.PUT,value="/{invoiceCode}")
    void updateInvoice(@PathVariable("invoiceCode") long code, @RequestBody resInvoice updatedInvoice);

    @RequestMapping(method= RequestMethod.DELETE,value="/{invoiceCode}")
    void deleteInvoice(@PathVariable("invoiceCode") long code);
}
