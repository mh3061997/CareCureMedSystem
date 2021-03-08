package com.carecure.medsysten.resources;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="resservicepricelist")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class resServicePriceList {

    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private long code;

    private String speciality;
    private String name;
    private int price;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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

    public resServicePriceList() {
    }

    public resServicePriceList(long code, String speciality, String name, int price) {
        this.code = code;
        this.speciality = speciality;
        this.name = name;
        this.price = price;
    }


}
