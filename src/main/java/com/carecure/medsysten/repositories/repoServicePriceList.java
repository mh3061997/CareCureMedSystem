package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resPatient;
import com.carecure.medsysten.resources.resServicePriceList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface repoServicePriceList extends CrudRepository<resServicePriceList,Long> {

    List<resServicePriceList> findBySpeciality(String speciality);

}
