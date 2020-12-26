package com.carecure.medsysten.resources;


import javax.persistence.*;
import java.util.Date;

@Entity
public class resAppointment {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private long code;
    private String speciality;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateToVisit;
    private String status;
    private String notes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorCode")
    private resDoctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientCode")
    private resPatient patient;


    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    public resAppointment(long code, String speciality, Date dateCreated, Date dateToVisit, String status, String notes, resDoctor doctor, resPatient patient) {
        this.code = code;
        this.speciality = speciality;
        this.dateCreated = dateCreated;
        this.dateToVisit = dateToVisit;
        this.status = status;
        this.notes = notes;
        this.doctor = doctor;
        this.patient = patient;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateToVisit() {
        return dateToVisit;
    }

    public void setDateToVisit(Date dateToVisit) {
        this.dateToVisit = dateToVisit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public resAppointment() {
    }
}
