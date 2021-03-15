package com.carecure.medsysten.security.models;


import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resPatient;

import java.util.HashSet;
import java.util.Set;

public class userDtoRegister {
    private String username;
    private String password;
    private resPatient patient;
    private resDoctor doctor;
    private Set<role> roles = new HashSet<>();

    public Set<role> getRoles() {
        return roles;
    }

    public void setRoles(Set<role> roles) {
        this.roles = roles;
    }

    public resDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(resDoctor doctor) {
        this.doctor = doctor;
    }

    public resPatient getPatient() {
        return patient;
    }

    public void setPatient(resPatient patient) {
        this.patient = patient;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}