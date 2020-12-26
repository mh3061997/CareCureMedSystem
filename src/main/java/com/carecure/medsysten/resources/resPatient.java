package com.carecure.medsysten.resources;

import javax.persistence.*;
import java.util.List;

@Entity
public class resPatient {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private long code;
    private String name;
    private String gender;
    private String email;
    private String mobile;
    private int age;

    private String notes;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "patient")
    List<resPackageMembership> memberships;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "patient")
    List<resAppointment> appointments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "patient")
    List<resMedImage> medImages;



    public resPatient(long code, String name, String gender, String email, String mobile, int age, String notes, List<resPackageMembership> memberships, List<resAppointment> appointments, List<resMedImage> medImages) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
        this.notes = notes;
        this.memberships = memberships;
        this.appointments = appointments;
        this.medImages = medImages;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public resPatient() {
    }

    public List<resPackageMembership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<resPackageMembership> memberships) {
        this.memberships = memberships;
    }

    public List<resAppointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<resAppointment> appointments) {
        this.appointments = appointments;
    }

    public List<resMedImage> getMedImages() {
        return medImages;
    }

    public void setMedImages(List<resMedImage> medImages) {
        this.medImages = medImages;
    }



    // resAppointment history

    //radiology;

    //lab

    //prescription

}
