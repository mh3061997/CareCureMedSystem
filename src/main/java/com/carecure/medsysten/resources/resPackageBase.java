package com.carecure.medsysten.resources;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class resPackageBase {

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private long code;
    private String name;

    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date dateExpired;

    private String status; //ongoing or expired
    private long price;
    private long unitTotal;
    private String Type;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "packageBase")
    private List<resPackageMembership> memberships;

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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateExpired() {
        return dateExpired;
    }

    public void setDateExpired(Date dateExpired) {
        this.dateExpired = dateExpired;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getUnitTotal() {
        return unitTotal;
    }

    public void setUnitTotal(long unitTotal) {
        this.unitTotal = unitTotal;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public List<resPackageMembership> getMemberships() {
        return memberships;
    }

    public void setMemberships(List<resPackageMembership> memberships) {
        this.memberships = memberships;
    }

    public resPackageBase(long code, String name, Date dateCreated, Date dateExpired, String status, long price, long unitTotal, String type, List<resPackageMembership> memberships) {
        this.code = code;
        this.name = name;
        this.dateCreated = dateCreated;
        this.dateExpired = dateExpired;
        this.status = status;
        this.price = price;
        this.unitTotal = unitTotal;
        Type = type;
        this.memberships = memberships;
    }

    public resPackageBase() {
    }




}
