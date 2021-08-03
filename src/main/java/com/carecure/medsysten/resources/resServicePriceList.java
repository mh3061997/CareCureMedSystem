package com.carecure.medsysten.resources;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="resservicepricelist")
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
public class resServicePriceList {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;

    private String speciality;
    private String name;
    private int price;

}
