package com.carecure.medsysten.services;


import com.carecure.medsysten.repositories.repoInvoice;
import com.carecure.medsysten.repositories.repoPatient;
import com.carecure.medsysten.resources.resAppointment;
import com.carecure.medsysten.resources.resInvoice;
import com.carecure.medsysten.resources.resPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class servInvoice {

    @Autowired
    repoInvoice repoInvoice;
    @Autowired
    com.carecure.medsysten.repositories.repoPatient repoPatient;
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


    public List<resInvoice> getInvoicesByDate(String date) {
        List<resInvoice> invoiceList = new ArrayList<>();
        repoInvoice.findByDateCreated(date).forEach(invoiceList::add);
        return invoiceList;
    }

    public resInvoice  addInvoice(resInvoice newInvoice){
       return repoInvoice.save(newInvoice);
    }


    public void updateInvoice(long invoiceCode, resInvoice updatedInvoice){
        Optional<resInvoice> invoice = repoInvoice.findById(invoiceCode);
      //  System.out.println("debt ss "+updatedInvoice.getStatus()+" "+ updatedInvoice.getTotalRemaining());
        if(invoice.isPresent()){
           // System.out.println("debt YY "+updatedInvoice.getStatus()+" "+ updatedInvoice.getTotalRemaining());

            if(updatedInvoice.getStatus().equals("Debt") && updatedInvoice.getTotalRemaining() >0 ){
            //    System.out.println("debt XX "+updatedInvoice.getStatus()+" "+ updatedInvoice.getTotalRemaining());

                resAppointment appointment = updatedInvoice.getAppointment();
                if(appointment !=null) {
                    resPatient patient = appointment.getPatient();
//                    System.out.println("debt"+ updatedInvoice.getTotalRemaining());
                    patient.setTotalDebt(patient.getTotalDebt()+updatedInvoice.getTotalRemaining());
                    repoPatient.save(patient);
                } else if(updatedInvoice.getPatientMembershipSubscriber() != null){
                    resPatient patient = updatedInvoice.getPatientMembershipSubscriber();
//                    System.out.println("debt"+ updatedInvoice.getTotalRemaining());
                    patient.setTotalDebt(patient.getTotalDebt()+updatedInvoice.getTotalRemaining());
                    repoPatient.save(patient);
                }
            }
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
