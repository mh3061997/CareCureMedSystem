package com.carecure.medsysten.resources;

import javax.persistence.*;
import java.util.Date;

@Entity
public class resMedImage {
    @Id
    private long code;
    private String image;
    private String type; // prescription , radiology, lab

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateAdded;

    private long patientCode;
    private String patientName;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public long getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(long patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public resMedImage(long code, String image, String type, Date dateAdded, long patientCode, String patientName) {
        this.code = code;
        this.image = image;
        this.type = type;
        this.dateAdded = dateAdded;
        this.patientCode = patientCode;
        this.patientName = patientName;
    }

    public resMedImage() {
    }
}
