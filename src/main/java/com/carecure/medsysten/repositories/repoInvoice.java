package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resInvoice;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface repoInvoice extends CrudRepository<resInvoice,Long> {

     List<resInvoice> findByDateCreated(Date dateCreated);
     List<resInvoice> findByStatus(String status);


}
