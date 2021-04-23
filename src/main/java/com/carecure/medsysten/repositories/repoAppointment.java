package com.carecure.medsysten.repositories;

import com.carecure.medsysten.interfaces.doctorReservedTimes;
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

    @Query(value="select * from resappointment app  where DATE(CONVERT_TZ(app.dateToVisit,'+00:00','+02:00')) < DATE(CONVERT_TZ(?1,'+00:00','+02:00'))",nativeQuery=true)
    List<resAppointment> findByDateToVisitLessThan(Date currentDate);

    @Query(value="select * from resappointment app  where DATE(CONVERT_TZ(app.dateToVisit,'+00:00','+02:00')) >= DATE(CONVERT_TZ(?1,'+00:00','+02:00'))",nativeQuery=true)
    List<resAppointment> findByDateToVisitGreaterThanEqual(Date currentDate);

    @Query(value="select * from resappointment app  where DATE(CONVERT_TZ(app.dateToVisit,'+00:00','+02:00')) <  DATE(CONVERT_TZ(?1,'+00:00','+02:00')) and app.doctorCode = ?2",nativeQuery=true)
    List<resAppointment> findByDateToVisitLessThanAndDoctorCode(Date currentDate,long doctorCode);

    @Query(value="select * from resappointment app  where DATE(CONVERT_TZ(app.dateToVisit,'+00:00','+02:00')) >=  DATE(CONVERT_TZ(?1,'+00:00','+02:00')) and app.doctorCode = ?2",nativeQuery=true)
    List<resAppointment> findByDateToVisitGreaterThanEqualAndDoctorCode(Date currentDate,long doctorCode);

    List<resAppointment> findByDateToVisitLessThanAndPatientCode(Date currentDate,long patientCode);
    List<resAppointment> findByDateToVisitGreaterThanEqualAndPatientCode(Date currentDate,long patientCode);

    @Query(value="select * from resappointment app  where DATE(CONVERT_TZ(app.dateToVisit,'+00:00','+02:00')) =  DATE(CONVERT_TZ(?1,'+00:00','+02:00')) and app.doctorCode = ?2",nativeQuery=true)
    List<resAppointment> findByDateToVisitAndDoctorCode(String date, long doctorCode);

    @Query(value="select * from resappointment app  where DATE(CONVERT_TZ(app.dateToVisit,'+00:00','+02:00')) = DATE(CONVERT_TZ(?1,'+00:00','+02:00'))",nativeQuery=true)
    List<resAppointment> findByDateToVisit(String date);

    @Query(value="select dateToVisit from resappointment app  where  app.doctorCode = ?1 and app.status!='Cancelled' " +
            "and DATE(CONVERT_TZ(app.dateToVisit,'+00:00','+02:00')) = DATE(CONVERT_TZ(?2,'+00:00','+02:00'))",nativeQuery=true)
    List<doctorReservedTimes> findDoctorReservedTimesByDate(long doctorCode,String date);
}



