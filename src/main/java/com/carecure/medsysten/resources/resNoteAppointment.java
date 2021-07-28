package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="resnoteappointment")
@JsonIgnoreProperties("hibernateLazyInitializer")
@ToString
public class resNoteAppointment {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;

    private String note;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointmentCode")
    @JsonBackReference
    private resAppointment appointment;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public resAppointment getAppointment() {
        return appointment;
    }

    public void setAppointment(resAppointment appointment) {
        this.appointment = appointment;
    }

    public resNoteAppointment() {
    }

    public resNoteAppointment(long code, String note, resAppointment appointment) {
        this.code = code;
        this.note = note;
        this.appointment = appointment;
    }

    @Override
    public boolean equals(Object obj){
        resNoteAppointment note = (resNoteAppointment) obj;
        return note.getNote().equals(this.getNote()) && note.getCode() == this.getCode();
    }
}
