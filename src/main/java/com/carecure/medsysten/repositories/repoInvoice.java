package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resInvoice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface repoInvoice extends CrudRepository<resInvoice,Long> {

     List<resInvoice> findByStatus(String status);

     @Query(value="select * from resinvoice invoice  where DATE(CONVERT_TZ(invoice.DateCreated,'+00:00','+02:00')) = DATE(CONVERT_TZ(?1,'+00:00','+02:00'))",nativeQuery=true)
     List<resInvoice> findByDateCreated(String dateCreated);

}
