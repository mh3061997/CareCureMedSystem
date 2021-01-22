package com.carecure.medsysten.resources;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class resAppointment {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;
    private String speciality;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateToVisit;
    private String status;
    private String type;
    private String notes;

    //@JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorCode")
    private resDoctor doctor;

    //@JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientCode")
    private resPatient patient;

    @OneToMany(fetch=FetchType.LAZY,mappedBy = "appointment")
    private List<resNoteAppointment> doctorNotes;
    @OneToOne(fetch = FetchType.LAZY,mappedBy = "appointment")
    private resInvoice invoice;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotes() {
        return notes;
    }

    public List<resNoteAppointment> getDoctorNotes() {
        return doctorNotes;
    }

    public void setDoctorNotes(List<resNoteAppointment> doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public resInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(resInvoice invoice) {
        this.invoice = invoice;
    }

    public resAppointment(long code, String speciality, Date dateCreated, Date dateToVisit, String status, String type, String notes, resDoctor doctor, resPatient patient, List<resNoteAppointment> doctorNotes, resInvoice invoice) {
        this.code = code;
        this.speciality = speciality;
        this.dateCreated = dateCreated;
        this.dateToVisit = dateToVisit;
        this.status = status;
        this.type = type;
        this.notes = notes;
        this.doctor = doctor;
        this.patient = patient;
        this.doctorNotes = doctorNotes;
        this.invoice = invoice;
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
