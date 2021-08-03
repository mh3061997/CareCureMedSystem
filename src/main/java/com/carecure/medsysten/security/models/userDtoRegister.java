package com.carecure.medsysten.security.models;


import com.carecure.medsysten.resources.resDoctor;
import com.carecure.medsysten.resources.resPatient;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class userDtoRegister {
    private String name;
    private String username;
    private String password;
    private resPatient patient;
    private resDoctor doctor;
    private Set<role> roles = new HashSet<>();

}
