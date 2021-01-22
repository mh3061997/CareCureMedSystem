package com.carecure.medsysten.services;


import com.carecure.medsysten.repositories.repoInvoice;
import com.carecure.medsysten.repositories.repoInvoiceItem;
import com.carecure.medsysten.resources.resInvoice;
import com.carecure.medsysten.resources.resInvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class servInvoiceItem {

    @Autowired
    repoInvoiceItem repoInvoiceItem;
    @Autowired
    servInvoice servInvoice;

    //return all invoices in db
    public List<resInvoiceItem> getInvoiceItemAll(){
        List<resInvoiceItem> InvoiceItemList = new ArrayList<>();
        repoInvoiceItem.findAll().forEach(InvoiceItemList::add);
        return InvoiceItemList;
    }

    //return app by id
    public resInvoiceItem getInvoiceItemByCode(long code){
        Optional<resInvoiceItem> invoice = repoInvoiceItem.findById(code);
        if(invoice.isPresent())
            return invoice.get();
        else
            //throw exception
            return null;
    }

    public void  addInvoiceItem(resInvoiceItem newInvoiceItem){

        repoInvoiceItem.save(newInvoiceItem);
        resInvoice invoice = newInvoiceItem.getInvoice();
        invoice = servInvoice.getInvoiceByCode(invoice.getCode());
        invoice.setTotalDue(invoice.getTotalDue()+newInvoiceItem.getPrice());
        invoice.setTotalRemaining(invoice.getTotalRemaining()+newInvoiceItem.getPrice());
        invoice.setTotalAfterDiscount(invoice.getTotalAfterDiscount()+newInvoiceItem.getPrice());
        servInvoice.updateInvoice(invoice.getCode(),invoice);
    }

    public void updateInvoiceItem(long invoiceCode, resInvoiceItem updatedInvoiceItem){
        Optional<resInvoiceItem> invoice = repoInvoiceItem.findById(invoiceCode);
        if(invoice.isPresent()){
            updatedInvoiceItem.setCode(invoiceCode);
            repoInvoiceItem.save(updatedInvoiceItem);
        }
    }

    public void deleteInvoiceItem(long code){

        Optional<resInvoiceItem> invoiceItem = repoInvoiceItem.findById(code);
        if(invoiceItem.isPresent()){

            resInvoice invoice = invoiceItem.get().getInvoice();
            invoice = servInvoice.getInvoiceByCode(invoice.getCode());
            invoice.setTotalDue(invoice.getTotalDue()-invoiceItem.get().getPrice());
            invoice.setTotalRemaining(invoice.getTotalRemaining()-invoiceItem.get().getPrice());
            invoice.setTotalAfterDiscount(invoice.getTotalAfterDiscount()-invoiceItem.get().getPrice());
            servInvoice.updateInvoice(invoice.getCode(),invoice);
            repoInvoiceItem.deleteById(code);
        }

        else
            //throw exception
            return;
    }

    public void addInvoiceItemMulti(List<resInvoiceItem> newInvoiceItemArr) {
        newInvoiceItemArr.forEach(invoiceItem ->{
            repoInvoiceItem.save(invoiceItem);
        });
    }
}
