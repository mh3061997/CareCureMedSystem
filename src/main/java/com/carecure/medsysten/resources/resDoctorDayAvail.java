package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="resdoctordayavail")

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

    public resDoctorDayAvail() {
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }


    public String getStartTimeAMPM() {
        return startTimeAMPM;
    }

    public void setStartTimeAMPM(String startTimeAMPM) {
        this.startTimeAMPM = startTimeAMPM;
    }



    public String getEndTimeAMPM() {
        return endTimeAMPM;
    }

    public void setEndTimeAMPM(String endTimeAMPM) {
        this.endTimeAMPM = endTimeAMPM;
    }

    public resDoctor getDoctor() {
        return doctor;
    }

    public void setDoctor(resDoctor doctor) {
        this.doctor = doctor;
    }

    public String getStartTimeHour() {
        return startTimeHour;
    }

    public void setStartTimeHour(String startTimeHour) {
        this.startTimeHour = startTimeHour;
    }

    public String getStartTimeMinute() {
        return startTimeMinute;
    }

    public void setStartTimeMinute(String startTimeMinute) {
        this.startTimeMinute = startTimeMinute;
    }

    public String getEndTimeHour() {
        return endTimeHour;
    }

    public void setEndTimeHour(String endTimeHour) {
        this.endTimeHour = endTimeHour;
    }

    public String getEndTimeMinute() {
        return endTimeMinute;
    }

    public void setEndTimeMinute(String endTimeMinute) {
        this.endTimeMinute = endTimeMinute;
    }

    public resDoctorDayAvail(long code, String day, String startTimeHour, String startTimeMinute, String startTimeAMPM, String endTimeHour, String endTimeMinute, String endTimeAMPM, resDoctor doctor) {
        this.code = code;
        this.day = day;
        this.startTimeHour = startTimeHour;
        this.startTimeMinute = startTimeMinute;
        this.startTimeAMPM = startTimeAMPM;
        this.endTimeHour = endTimeHour;
        this.endTimeMinute = endTimeMinute;
        this.endTimeAMPM = endTimeAMPM;
        this.doctor = doctor;
    }
}
