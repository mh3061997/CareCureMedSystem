package com.carecure.medsysten.resources;

import javax.persistence.*;
import java.util.Date;

@Entity
public class resPackageMembership{

    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private long code;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateSubscriped;

    private long usedAmount;
    private long remainingAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientCode")
    private resPatient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packageCode")
    private resPackageBase packageBase;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getDateSubscriped() {
        return dateSubscriped;
    }

    public void setDateSubscriped(Date dateSubscripred) {
        this.dateSubscriped = dateSubscripred;
    }

    public long getUsedAmount() {
        return usedAmount;
    }

    public void setUsedAmount(long usedAmount) {
        this.usedAmount = usedAmount;
    }

    public long getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(long remainingAmount) {
        this.remainingAmount = remainingAmount;
    }


    public resPatient getPatient() {
        return patient;
    }

    public void setPatient(resPatient patient) {
        this.patient = patient;
    }

    public resPackageBase getPackageBase() {
        return packageBase;
    }

    public void setPackageBase(resPackageBase packageBase) {
        this.packageBase = packageBase;
    }

    public resPackageMembership(long code, Date dateSubscriped, long usedAmount, long remainingAmount, resPatient patient, resPackageBase packageBase) {
        this.code = code;
        this.dateSubscriped = dateSubscriped;
        this.usedAmount = usedAmount;
        this.remainingAmount = remainingAmount;
        this.patient = patient;
        this.packageBase = packageBase;
    }

    public resPackageMembership() {
    }
}
