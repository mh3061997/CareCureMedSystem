package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resAppointment;
import org.springframework.data.repository.CrudRepository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

//use this annotation only if table name is different than default
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface repoAppointment extends CrudRepository<resAppointment, Long> {

    List<resAppointment> findBySpeciality(String speciality);
    List<resAppointment> findByStatus(String Status);
    List<resAppointment> findByPatientName(String name);
    List<resAppointment> findByDoctorName(String name);
    List<resAppointment> findByDateCreatedLessThanEqual(Date dateCreated);
    List<resAppointment> findByDateCreated(Date dateCreated);
    List<resAppointment> findByDateToVisit(Date dateToVisit);
    List<resAppointment> findByPatientCodeAndDoctorCode(long patientCode, long doctorCode);
    List<resAppointment> findByDateToVisitLessThan(Date currentDate);
    List<resAppointment> findByDateToVisitGreaterThanEqual(Date currentDate);
}



