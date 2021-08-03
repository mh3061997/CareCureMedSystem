package com.carecure.medsysten.resources;

import com.carecure.medsysten.security.models.UserDao;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="respatient")
@JsonIgnoreProperties("hibernateLazyInitializer")

public class resPatient {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;
    private String name;
    private String gender;
    private String email;
    private String mobile;
    private int age;
    private long totalDebt;
    private String notes;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "patientMembershipSubscriber")
    List<resInvoice> invoiceMemberships;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "patient")
    List<resPackageMembership> memberships;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "patient")
    List<resAppointment> appointments;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "patient")
    List<resMedImage> medImages;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY ,mappedBy = "patient")
    private UserDao user;

}
