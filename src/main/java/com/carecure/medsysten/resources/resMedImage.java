package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="resmedimage")
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
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


}
