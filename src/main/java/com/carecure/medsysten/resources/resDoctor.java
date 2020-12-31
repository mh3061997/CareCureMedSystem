package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")

public class resDoctor {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;
    private String name;
    private String mobile;



    private String email;
    private String gender;
    private int age;
    private  String speciality;

    //@JsonBackReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "doctor")
    List<resAppointment> appointments;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public resDoctor(long code, String name, String mobile, String email, String gender, int age, String speciality, List<resAppointment> appointments) {
        this.code = code;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.gender = gender;
        this.age = age;
        this.speciality = speciality;
        this.appointments = appointments;
    }

    public List<resAppointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<resAppointment> appointments) {
        this.appointments = appointments;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }



    public resDoctor() {
    }

    //appointments;

    //upcoming appointements

    //days available


}
