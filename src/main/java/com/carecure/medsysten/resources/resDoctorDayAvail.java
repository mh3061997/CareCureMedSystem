package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class resDoctorDayAvail {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;

    private String day;
    private String startTime;
    private String startTimeAMPM;
    private String endTime;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTimeAMPM() {
        return startTimeAMPM;
    }

    public void setStartTimeAMPM(String startTimeAMPM) {
        this.startTimeAMPM = startTimeAMPM;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public resDoctorDayAvail(long code, String day, String startTime, String startTimeAMPM, String endTime, String endTimeAMPM, resDoctor doctor) {
        this.code = code;
        this.day = day;
        this.startTime = startTime;
        this.startTimeAMPM = startTimeAMPM;
        this.endTime = endTime;
        this.endTimeAMPM = endTimeAMPM;
        this.doctor = doctor;
    }
}
