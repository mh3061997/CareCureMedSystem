package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="resinvoice")

@JsonIgnoreProperties("hibernateLazyInitializer")
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointmentCode")
    private resAppointment appointment;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "invoice")
    private List<resInvoiceItem> invoiceItems;

    @ManyToOne(fetch=FetchType.LAZY)
    private resPackageMembership   usedMembership;

    private String paymentMethod;

    public resInvoice() {
    }

    public List<resInvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<resInvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public resPackageMembership getUsedMembership() {
        return usedMembership;
    }

    public void setUsedMembership(resPackageMembership usedMembership) {
        this.usedMembership = usedMembership;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public long getTotalAfterDiscount() {
        return totalAfterDiscount;
    }

    public void setTotalAfterDiscount(long totalAfterDiscount) {
        this.totalAfterDiscount = totalAfterDiscount;
    }

    public resInvoice(long code, Date dateCreated, Date dateFinalized, long totalDue, long totalAfterDiscount, long totalPaid, long totalRemaining, String status, int discount, resAppointment appointment, List<resInvoiceItem> invoiceItems, resPackageMembership usedMembership, String paymentMethod) {
        this.code = code;
        this.dateCreated = dateCreated;
        this.dateFinalized = dateFinalized;
        this.totalDue = totalDue;
        this.totalAfterDiscount = totalAfterDiscount;
        this.totalPaid = totalPaid;
        this.totalRemaining = totalRemaining;
        this.status = status;
        this.discount = discount;
        this.appointment = appointment;
        this.invoiceItems = invoiceItems;
        this.usedMembership = usedMembership;
        this.paymentMethod = paymentMethod;
    }

    public resAppointment getAppointment() {
        return appointment;
    }

    public void setAppointment(resAppointment appointment) {
        this.appointment = appointment;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateFinalized() {
        return dateFinalized;
    }

    public void setDateFinalized(Date dateFinalized) {
        this.dateFinalized = dateFinalized;
    }

    public long getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(long totalDue) {
        this.totalDue = totalDue;
    }

    public long getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(long totalPaid) {
        this.totalPaid = totalPaid;
    }

    public long getTotalRemaining() {
        return totalRemaining;
    }

    public void setTotalRemaining(long totalRemaining) {
        this.totalRemaining = totalRemaining;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
