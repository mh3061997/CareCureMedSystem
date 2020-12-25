package com.carecure.medsysten.resources;

import javax.persistence.*;
import java.util.Date;

@Entity
public class appointement {

    @Id
    private long code;
    private String speciality;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateToVisit;
    private String status;

    private String doctorName;
    private long patientName;
    private long patientCode;

    //radiology

    //lab

    //prescription

}
