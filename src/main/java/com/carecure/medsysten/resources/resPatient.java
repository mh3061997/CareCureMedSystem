package com.carecure.medsysten.resources;

import com.carecure.medsysten.security.models.UserDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="respatient")
@JsonIgnoreProperties("hibernateLazyInitializer")

public class resPatient {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;
    private String name;
    private String gender;
    private String email;
    private String mobile;
    private int age;
    private long totalDebt;
    private String notes;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patientMembershipSubscriber")
    List<resInvoice> invoiceMemberships;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patient")
    List<resPackageMembership> memberships;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patient")
    List<resAppointment> appointments;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "patient")
    List<resMedImage> medImages;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER ,mappedBy = "patient")
    private UserDao user;

    public List<resInvoice> getInvoiceMemberships()
    {
        return invoiceMemberships;
    }

    public void setInvoiceMemberships(List<resInvoice> invoiceMemberships)
    {
        this.invoiceMemberships = invoiceMemberships;
    }

    public long getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(long totalDebt) {
        this.totalDebt = totalDebt;
    }

    public UserDao getUser() {
        return user;
    }

    public void setUser(UserDao user) {
        this.user = user;
    }

    public resPatient(long code, String name, String gender, String email, String mobile, int age, long totalDebt,
            String notes, List<resInvoice> invoiceMemberships, List<resPackageMembership> memberships,
            List<resAppointment> appointments, List<resMedImage> medImages, UserDao user)
    {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
        this.totalDebt = totalDebt;
        this.notes = notes;
        this.invoiceMemberships = invoiceMemberships;
        this.memberships = memberships;
        this.appointments = appointments;
        this.medImages = medImages;
        this.user = user;
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
