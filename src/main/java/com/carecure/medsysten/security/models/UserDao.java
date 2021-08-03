package com.carecure.medsysten.security.models;

import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resPatient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserDao {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    @Column
    private String name;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    private boolean enabled =true;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<role> roles = new HashSet<>();


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientCode",unique = true)
    @JsonIgnoreProperties({"memberships","appointments","medImages","user"})
    private resPatient patient;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorCode",unique = true)
    @JsonIgnoreProperties({"appointments","availableDays","user"})
    private resDoctor doctor;



}
