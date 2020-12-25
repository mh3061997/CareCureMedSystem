package com.carecure.medsysten.resources;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class patient {
    @Id
    private long code;
    private String name;
    private String gender;
    private String email;
    private String mobile;
    private int age;

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

    public patient() {
    }

    public patient(long code, String name, String gender, String email, String mobile, int age) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
    }
// appointement history

    //radiology;

    //lab

    //prescription

}
