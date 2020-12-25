package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resAppointment;
import org.springframework.data.repository.CrudRepository;

//use this annotation only if table name is different than default
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface repoAppointment extends CrudRepository<resAppointment, Long> {

}



