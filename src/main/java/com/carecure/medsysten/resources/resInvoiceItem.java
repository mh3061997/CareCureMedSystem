package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
public class resInvoiceItem {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;

    private String name;
    private int price;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoiceCode")
    private resInvoice invoice;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public resInvoice getInvoice() {
        return invoice;
    }

    public void setInvoice(resInvoice invoice) {
        this.invoice = invoice;
    }

    public resInvoiceItem(long code, String name, int price, resInvoice invoice) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.invoice = invoice;
    }

    public resInvoiceItem() {
    }
}
