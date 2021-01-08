package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resInvoiceItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/invoiceItem")
public interface contIntInvoiceItem {

    @RequestMapping
    List<resInvoiceItem> getInvoiceItemAll();

    @RequestMapping("/{invoiceItemCode}")
    resInvoiceItem getInvoiceItemById(@PathVariable("invoiceItemCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addInvoiceItem(@RequestBody resInvoiceItem newInvoiceItem);

    @RequestMapping(method = RequestMethod.PUT,value="/{invoiceItemCode}")
    void updateInvoiceItem(@PathVariable("invoiceItemCode") long code, @RequestBody resInvoiceItem updatedInvoiceItem);

    @RequestMapping(method= RequestMethod.DELETE,value="/{invoiceItemCode}")
    void deleteInvoiceItem(@PathVariable("invoiceItemCode") long code);
}
