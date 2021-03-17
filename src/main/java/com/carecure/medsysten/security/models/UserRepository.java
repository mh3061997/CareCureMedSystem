package com.carecure.medsysten.security.models;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Long> {
    UserDao findByUsername(String username);

    UserDao findByPatientCode(long code);

    UserDao findByDoctorCode(long code);

}