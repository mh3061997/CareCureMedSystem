package com.carecure.medsysten.resources;

import javax.persistence.*;
import java.util.Date;

@Entity
public class invoice {

    @Id
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

    private long patientCode;
    private long patientName;
    private long appointementCode;

    private String paymentMethod;

    public invoice() {
    }

    public invoice(long code, Date dateCreated, Date dateFinalized, long totalDue, long totalPaid, long totalRemaining, String status, long patientCode, long patientName, long appointementCode, String paymentMethod) {
        this.code = code;
        this.dateCreated = dateCreated;
        this.dateFinalized = dateFinalized;
        this.totalDue = totalDue;
        this.totalPaid = totalPaid;
        this.totalRemaining = totalRemaining;
        this.status = status;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.appointementCode = appointementCode;
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

    public long getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(long patientCode) {
        this.patientCode = patientCode;
    }

    public long getPatientName() {
        return patientName;
    }

    public void setPatientName(long patientName) {
        this.patientName = patientName;
    }

    public long getAppointementCode() {
        return appointementCode;
    }

    public void setAppointementCode(long appointementCode) {
        this.appointementCode = appointementCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
