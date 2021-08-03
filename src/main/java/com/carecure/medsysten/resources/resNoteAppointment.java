package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="resnoteappointment")
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
public class resNoteAppointment {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;

    private String note;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointmentCode")
    @JsonBackReference
    private resAppointment appointment;


}
