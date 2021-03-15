package com.carecure.medsysten.security.models;

import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resPatient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserDao {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    private boolean enabled =true;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<role> roles = new HashSet<>();


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientCode",unique = true)
    private resPatient patient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorCode",unique = true)
    private resDoctor doctor;


    public resDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(resDoctor doctor) {
        this.doctor = doctor;
    }

    public UserDao(long code, String username, String password, boolean enabled, Set<role> roles, resPatient patient, resDoctor doctor) {
        this.code = code;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
        this.patient = patient;
        this.doctor = doctor;
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

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<role> getRoles() {
        return roles;
    }

    public void setRoles(Set<role> roles) {
        this.roles = roles;
    }

    public UserDao() {
    }

    public resPatient getPatient() {
        return patient;
    }

    public void setPatient(resPatient patient) {
        this.patient = patient;
    }
}
