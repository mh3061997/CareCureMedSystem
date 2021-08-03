package com.carecure.medsysten.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="respackagebase")
@JsonIgnoreProperties("hibernateLazyInitializer")
@Data
@NoArgsConstructor
public class resPackageBase {

    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY)
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
    private String type;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "packageBase")
    private List<resPackageMembership> memberships;

}
