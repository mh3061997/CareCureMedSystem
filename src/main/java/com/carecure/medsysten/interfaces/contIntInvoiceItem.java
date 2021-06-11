package com.carecure.medsysten.interfaces;

import com.carecure.medsysten.resources.resInvoiceItem;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping("/invoiceItem")
@Api(tags = "Invoice")
public interface contIntInvoiceItem {

    @RequestMapping(method = RequestMethod.GET)
    List<resInvoiceItem> getInvoiceItemAll();

    @RequestMapping(method = RequestMethod.GET,value="/{invoiceItemCode}")
    resInvoiceItem getInvoiceItemById(@PathVariable("invoiceItemCode") long code);

    @RequestMapping(method = RequestMethod.POST)
    void addInvoiceItem(@RequestBody resInvoiceItem newInvoiceItem);

    @RequestMapping(method = RequestMethod.POST,value="/addmulti")
    void addInvoiceItemMulti(@RequestBody List<resInvoiceItem> newInvoiceItemArr);

    @RequestMapping(method = RequestMethod.PUT,value="/{invoiceItemCode}")
    void updateInvoiceItem(@PathVariable("invoiceItemCode") long code, @RequestBody resInvoiceItem updatedInvoiceItem);

    @RequestMapping(method= RequestMethod.DELETE,value="/{invoiceItemCode}")
    void deleteInvoiceItem(@PathVariable("invoiceItemCode") long code);
}
