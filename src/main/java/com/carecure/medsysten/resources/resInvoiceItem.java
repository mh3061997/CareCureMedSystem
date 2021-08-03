package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="resinvoiceitem")
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
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


}
