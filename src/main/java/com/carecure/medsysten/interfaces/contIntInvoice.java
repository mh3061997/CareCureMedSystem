package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resInvoice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/invoice")
public interface contIntInvoice {

    @RequestMapping
    List<resInvoice> getInvoiceAll();

    @RequestMapping("/{invoiceCode}")
    resInvoice getInvoiceById(@PathVariable("invoiceCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    resInvoice addInvoice(@RequestBody resInvoice newInvoice);

    @RequestMapping(method = RequestMethod.PUT,value="/{invoiceCode}")
    void updateInvoice(@PathVariable("invoiceCode") long code, @RequestBody resInvoice updatedInvoice);

    @RequestMapping(method= RequestMethod.DELETE,value="/{invoiceCode}")
    void deleteInvoice(@PathVariable("invoiceCode") long code);
}
