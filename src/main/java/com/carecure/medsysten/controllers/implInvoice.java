package com.carecure.medsysten.controllers;

import com.carecure.medsysten.interfaces.contIntInvoice;
import com.carecure.medsysten.resources.resInvoice;
import com.carecure.medsysten.services.servInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class implInvoice implements contIntInvoice {

    @Autowired
    private servInvoice servInvoice;


    @Override
    public List<resInvoice> getInvoiceAll() {
        return servInvoice.getInvoiceAll();
    }

    @Override
    public resInvoice getInvoiceById(long code) {
        return servInvoice.getInvoiceByCode(code);
    }

    @Override
    public void addInvoice(resInvoice newInvoice) {
        servInvoice.addInvoice(newInvoice);
    }

    @Override
    public void updateInvoice(long code, resInvoice updatedInvoice) {
        servInvoice.updateInvoice(code,updatedInvoice);
    }

    @Override
    public void deleteInvoice(long code) {
        servInvoice.deleteInvoice(code);
    }
}
