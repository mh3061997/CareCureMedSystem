package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")

public class resMedImage {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private long code;
    private String image;
    private String type; // prescription , radiology, lab

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateAdded;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "patientCode")
   @JsonBackReference //never will i access medimages directly to keep controller clean
   private resPatient patient;

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


    public resPatient getPatient() {
        return patient;
    }

    public void setPatient(resPatient patient) {
        this.patient = patient;
    }

    public resMedImage(long code, String image, String type, Date dateAdded, resPatient patient) {
        this.code = code;
        this.image = image;
        this.type = type;
        this.dateAdded = dateAdded;
        this.patient = patient;
    }

    public resMedImage() {
    }
}
