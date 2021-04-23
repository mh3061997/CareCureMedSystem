package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="resmedimage")
@JsonIgnoreProperties("hibernateLazyInitializer")

public class resMedImage {
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private long code;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String image;

    private String type; // prescription , radiology, lab
    private String subType; //sonar , makta3y , etc.
    private String organ;   //sadr , kela .etc.
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateAdded;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateMade;

    public Date getDateMade() {
        return dateMade;
    }

    public void setDateMade(Date dateMade) {
        this.dateMade = dateMade;
    }

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

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public resMedImage(long code, String image, String type, String subType, String organ, Date dateAdded, Date dateMade, resPatient patient) {
        this.code = code;
        this.image = image;
        this.type = type;
        this.subType = subType;
        this.organ = organ;
        this.dateAdded = dateAdded;
        this.dateMade = dateMade;
        this.patient = patient;
    }

    public resMedImage() {
    }
}
