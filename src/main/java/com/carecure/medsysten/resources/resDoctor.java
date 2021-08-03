package com.carecure.medsysten.resources;

import com.carecure.medsysten.security.models.UserDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="resdoctor")

@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
public class resDoctor {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;
    private String name;
    private String mobile;



    private String email;
    private String gender;
    private int age;
    private  String speciality;
    private int priceVisit;
    private int priceRevisit;

    //@JsonBackReference
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "doctor")
    List<resAppointment> appointments;

    @OneToMany(fetch=FetchType.LAZY,mappedBy="doctor")
    List<resDoctorDayAvail> availableDays;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY ,mappedBy = "doctor")
    private UserDao user;


}
