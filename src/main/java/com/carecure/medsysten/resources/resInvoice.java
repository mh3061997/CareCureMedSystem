package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")

public class resInvoice {

    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private long code;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinalized;

    private long totalDue;
    private long totalPaid;
    private long totalRemaining;

    private String status;


    @ManyToOne(fetch = FetchType.LAZY)
    private resPatient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    private resAppointment appointment;

    private String paymentMethod;

    public resInvoice() {
    }

    public resPatient getPatient() {
        return patient;
    }

    public void setPatient(resPatient patient) {
        this.patient = patient;
    }

    public resAppointment getAppointment() {
        return appointment;
    }

    public void setAppointment(resAppointment appointment) {
        this.appointment = appointment;
    }

    public resInvoice(long code, Date dateCreated, Date dateFinalized, long totalDue, long totalPaid, long totalRemaining, String status, resPatient patient, resAppointment appointment, String paymentMethod) {

        this.code = code;
        this.dateCreated = dateCreated;
        this.dateFinalized = dateFinalized;
        this.totalDue = totalDue;
        this.totalPaid = totalPaid;
        this.totalRemaining = totalRemaining;
        this.status = status;
        this.patient = patient;
        this.appointment = appointment;
        this.paymentMethod = paymentMethod;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateFinalized() {
        return dateFinalized;
    }

    public void setDateFinalized(Date dateFinalized) {
        this.dateFinalized = dateFinalized;
    }

    public long getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(long totalDue) {
        this.totalDue = totalDue;
    }

    public long getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(long totalPaid) {
        this.totalPaid = totalPaid;
    }

    public long getTotalRemaining() {
        return totalRemaining;
    }

    public void setTotalRemaining(long totalRemaining) {
        this.totalRemaining = totalRemaining;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
