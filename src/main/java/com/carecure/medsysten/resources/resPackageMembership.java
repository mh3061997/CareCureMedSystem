package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="respackagemembership")
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
public class resPackageMembership{

    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private long code;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateSubscriped;

    private long usedAmount;
    private long remainingAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientCode")
    private resPatient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packageCode")
    private resPackageBase packageBase;

}
