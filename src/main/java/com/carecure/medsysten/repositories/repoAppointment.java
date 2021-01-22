package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resAppointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.TemporalType;
import java.time.Instant;
import java.util.Date;
import java.util.List;

//use this annotation only if table name is different than default
//@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface repoAppointment extends CrudRepository<resAppointment, Long> {


    List<resAppointment> findByPatientCodeAndDoctorCode(long patientCode, long doctorCode);
    List<resAppointment> findByDateToVisitLessThan(Date currentDate);
    List<resAppointment> findByDateToVisitGreaterThanEqual(Date currentDate);
    List<resAppointment> findByDateToVisitLessThanAndDoctorCode(Date currentDate,long doctorCode);
    List<resAppointment> findByDateToVisitGreaterThanEqualAndDoctorCode(Date currentDate,long doctorCode);
    List<resAppointment> findByDateToVisitLessThanAndPatientCode(Date currentDate,long patientCode);
    List<resAppointment> findByDateToVisitGreaterThanEqualAndPatientCode(Date currentDate,long patientCode);

    @Query(value="select * from resappointment app  where DATE(app.dateToVisit) = ?1 and app.doctorCode = ?2",nativeQuery=true)
    List<resAppointment> findByDateToVisitAndDoctorCode(String date, long doctorCode);
}



