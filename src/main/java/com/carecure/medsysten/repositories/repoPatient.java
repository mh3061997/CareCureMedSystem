package com.carecure.medsysten.repositories;


import com.carecure.medsysten.resources.resPatient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface repoPatient extends CrudRepository<resPatient, Long> {
    List<resPatient> findByName(String name);

    resPatient findByMobile(String mobile);
}
