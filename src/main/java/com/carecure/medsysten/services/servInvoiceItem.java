package com.carecure.medsysten.services;


import com.carecure.medsysten.repositories.repoInvoiceItem;
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
    }

    public void updateInvoiceItem(long invoiceCode, resInvoiceItem updatedInvoiceItem){
        Optional<resInvoiceItem> invoice = repoInvoiceItem.findById(invoiceCode);
        if(invoice.isPresent()){
            updatedInvoiceItem.setCode(invoiceCode);
            repoInvoiceItem.save(updatedInvoiceItem);
        }
    }

    public void deleteInvoiceItem(long code){

        Optional<resInvoiceItem> invoice = repoInvoiceItem.findById(code);
        if(invoice.isPresent())
            repoInvoiceItem.deleteById(code);
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
