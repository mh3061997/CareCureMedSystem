package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="resinvoice")
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
public class resInvoice {

    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private long code;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFinalized;

    private long totalDue;
    private long totalAfterDiscount;
    private long totalPaid;
    private long totalRemaining;

    private String status;

    private int discount;

    private String userFinalizedBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointmentCode")
    private resAppointment appointment;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "invoice")
    private List<resInvoiceItem> invoiceItems;

    @ManyToOne(fetch=FetchType.LAZY)
    private resPackageMembership   usedMembership;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientMembershipSubscriberCode")
    private resPatient patientMembershipSubscriber;


    private String paymentMethod;



}
