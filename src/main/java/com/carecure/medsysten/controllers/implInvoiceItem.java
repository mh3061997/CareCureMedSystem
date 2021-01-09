package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntInvoiceItem;
import com.carecure.medsysten.resources.resInvoiceItem;
import com.carecure.medsysten.services.servInvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class implInvoiceItem implements contIntInvoiceItem {

    @Autowired
    private servInvoiceItem servInvoiceItem;


    @Override
    public List<resInvoiceItem> getInvoiceItemAll() {
        return servInvoiceItem.getInvoiceItemAll();
    }

    @Override
    public resInvoiceItem getInvoiceItemById(long code) {
        return servInvoiceItem.getInvoiceItemByCode(code);
    }

    @Override
    public void addInvoiceItem(resInvoiceItem newInvoiceItem) {
        servInvoiceItem.addInvoiceItem(newInvoiceItem);
    }

    @Override
    public void addInvoiceItemMulti(@RequestBody List<resInvoiceItem> newInvoiceItemArr){
         servInvoiceItem.addInvoiceItemMulti(newInvoiceItemArr);
    }


    @Override
    public void updateInvoiceItem(long code, resInvoiceItem updatedInvoiceItem) {
        servInvoiceItem.updateInvoiceItem(code,updatedInvoiceItem);
    }

    @Override
    public void deleteInvoiceItem(long code) {
        servInvoiceItem.deleteInvoiceItem(code);
    }
}
