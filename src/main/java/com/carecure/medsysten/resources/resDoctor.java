package com.carecure.medsysten.resources;

import javax.persistence.*;
import java.util.List;

@Entity
public class resDoctor {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private long code;
    private String name;
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private String email;
    private String Gender;
    private int age;
    private  String Speciality;
    @OneToMany
    List<resAppointment> appointments;

    public resDoctor(long code, String name, String mobile, String email, String gender, int age, String speciality, List<resAppointment> appointments) {
        this.code = code;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        Gender = gender;
        this.age = age;
        Speciality = speciality;
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
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }



    public resDoctor() {
    }

    //appointments;

    //upcoming appointements

    //days available


}
