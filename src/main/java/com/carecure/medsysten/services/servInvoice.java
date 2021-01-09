package com.carecure.medsysten.services;


import com.carecure.medsysten.repositories.repoInvoice;
import com.carecure.medsysten.resources.resInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servInvoice {

    @Autowired
    repoInvoice repoInvoice;

    //return all invoices in db
    public List<resInvoice> getInvoiceAll(){
        List<resInvoice> InvoiceList = new ArrayList<>();
        repoInvoice.findAll().forEach(InvoiceList::add);
        return InvoiceList;
    }

    //return app by id
    public resInvoice getInvoiceByCode(long code){
        Optional<resInvoice> invoice = repoInvoice.findById(code);
        if(invoice.isPresent())
            return invoice.get();
        else
            //throw exception
            return null;
    }

    public resInvoice  addInvoice(resInvoice newInvoice){
       return repoInvoice.save(newInvoice);
    }


    public void updateInvoice(long invoiceCode, resInvoice updatedInvoice){
        Optional<resInvoice> invoice = repoInvoice.findById(invoiceCode);
        if(invoice.isPresent()){
            updatedInvoice.setCode(invoiceCode);
            repoInvoice.save(updatedInvoice);
        }
    }

    public void deleteInvoice(long code){

        Optional<resInvoice> invoice = repoInvoice.findById(code);
        if(invoice.isPresent())
            repoInvoice.deleteById(code);
        else
            //throw exception
            return;
    }

}
