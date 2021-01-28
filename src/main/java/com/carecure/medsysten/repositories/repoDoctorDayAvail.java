package com.carecure.medsysten.repositories;

import com.carecure.medsysten.resources.resDoctorDayAvail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface repoDoctorDayAvail extends CrudRepository<resDoctorDayAvail,Long> {
    void deleteByDoctorCode(long code);
    List<resDoctorDayAvail> findByDoctorCode(long code);
}
