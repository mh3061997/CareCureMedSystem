package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resPatient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface repoDoctor extends CrudRepository<resDoctor, Long> {
    List<resDoctor> findByName(String name);

    List<resDoctor> findBySpeciality(String speciality);

    resDoctor findByMobile(String mobile);

}
