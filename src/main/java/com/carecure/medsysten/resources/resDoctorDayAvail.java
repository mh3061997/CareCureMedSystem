package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="resdoctordayavail")
@Data
@NoArgsConstructor
public class resDoctorDayAvail {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;

    private String day;
    private String startTimeHour;
    private String startTimeMinute;
    private String startTimeAMPM;
    private String endTimeHour;
    private String endTimeMinute;
    private String endTimeAMPM;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorCode")
    @JsonBackReference
    private resDoctor doctor;


}
