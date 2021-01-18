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
    /*select resappoint0_.code as code1_0_, resappoint0_.dateCreated as dateCrea2_0_, resappoint0_.dateToVisit as dateToVi3_0_, resappoint0_.doctorCode as doctorCo8_0_, resappoint0_.notes as notes4_0_, resappoint0_.patientCode as patientC9_0_, resappoint0_.speciality as speciali5_0_, resappoint0_.status as status6_0_, resappoint0_.type as type7_0_
    from resAppointment resappoint0_
    left outer join resDoctor resdoctor1_ on resappoint0_.doctorCode=resdoctor1_.code
    where resappoint0_.dateToVisit=? and resdoctor1_.code=?*/
    List<resAppointment> findByDateToVisitAndDoctorCode(String date, long doctorCode);
}



