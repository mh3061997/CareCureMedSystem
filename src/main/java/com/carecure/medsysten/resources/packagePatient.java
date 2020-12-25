package com.carecure.medsysten.resources;

import javax.persistence.*;
import java.util.Date;

@Entity
public class packagePatient extends packageBase{

    @Id
    private long code;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateSubscripred;

    private long usedAmount;
    private long remainingAmount;

    private long patientCode;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getDateSubscripred() {
        return dateSubscripred;
    }

    public void setDateSubscripred(Date dateSubscripred) {
        this.dateSubscripred = dateSubscripred;
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

    public long getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(long patientCode) {
        this.patientCode = patientCode;
    }

    public packagePatient(long code, Date dateSubscripred, long usedAmount, long remainingAmount, long patientCode) {
        this.code = code;
        this.dateSubscripred = dateSubscripred;
        this.usedAmount = usedAmount;
        this.remainingAmount = remainingAmount;
        this.patientCode = patientCode;
    }

    //implement super constructor

}
