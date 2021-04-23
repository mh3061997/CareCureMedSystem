package com.carecure.medsysten.security.models;
import org.springframework.data.repository.CrudRepository;

public interface roleRepository extends CrudRepository<role, Integer> {
    role findByname(String name);
}