package com.carecure.medsysten.resources;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class doctor {

    @Id
    private long code;
    private String name;
    private String email;
    private String Gender;
    private int age;
    private  String Speciality;

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

    public doctor(long code, String name, String email, String gender, int age, String speciality) {
        this.code = code;
        this.name = name;
        this.email = email;
        Gender = gender;
        this.age = age;
        Speciality = speciality;
    }

    public doctor() {
    }

    //appointments;

    //upcoming appointements

    //days available


}
