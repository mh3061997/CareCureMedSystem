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

    @OneToMany
    List<resPackageMembership> memberships;

    @OneToMany
    List<resAppointment> appointments;

    @OneToMany
    List<resMedImage> medImages;

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

    public resPatient(long code, String name, String gender, String email, String mobile, int age) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
    }
// resAppointment history

    //radiology;

    //lab

    //prescription

}
