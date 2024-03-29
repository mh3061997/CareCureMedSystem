package com.carecure.medsysten.security.controller;

import com.carecure.medsysten.security.models.*;
import com.carecure.medsysten.security.service.jwtUserDetailsService;
import com.carecure.medsysten.security.service.userDetails;
import com.carecure.medsysten.security.utils.jwtTokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
@Api(tags = "Authentication")
public class jwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtTokenUtil jwtTokenUtil;

    @Autowired
    private jwtUserDetailsService userDetailsService;

    @Autowired
    private roleRepository roleRepository;

    @Autowired
    private UserRepository repoUser;

    @Autowired
    private com.carecure.medsysten.repositories.repoDoctor repoDoctor;
    @Autowired
    private com.carecure.medsysten.repositories.repoPatient repoPatient;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> generateAuthenticationToken(@RequestBody jwtRequest authenticationRequest) throws Exception {

        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            final userDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new jwtResponse(token));

        } catch (BadCredentialsException e) {
            HashMap<String, String> errorMessageMap = new HashMap<>();
            errorMessageMap.put("message", "Wrong Username or Password !");
            System.out.println(errorMessageMap.toString());
            return new ResponseEntity<>(errorMessageMap, HttpStatus.UNAUTHORIZED);

        } catch (DisabledException e) {
            HashMap<String, String> errorMessageMap = new HashMap<>();
            errorMessageMap.put("message", "User Disabled !");
            System.out.println(errorMessageMap.toString());
            return new ResponseEntity<>(errorMessageMap, HttpStatus.UNAUTHORIZED);

        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> savePatient(@RequestBody userDtoRegister user) throws Exception {
        UserDao isUserNameTaken = repoUser.findByUsername(user.getUsername());

        if (isUserNameTaken != null) {
            HashMap<String, String> errorMessageMap = new HashMap<>();
            errorMessageMap.put("message", "Username taken !");

            return new ResponseEntity<>(errorMessageMap, HttpStatus.IM_USED);
        } else {

            Set<role> rolePatient = new HashSet<>();
            rolePatient.add(roleRepository.findByname("PATIENT"));
            user.setRoles(rolePatient);
            user.setName(user.getPatient().getName());
            return ResponseEntity.ok(userDetailsService.save(user));
        }

    }

    @RequestMapping(value = "/registerNonPatient", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody userDtoRegister user) throws Exception {
        UserDao isUserNameTaken = repoUser.findByUsername(user.getUsername());

        if (isUserNameTaken != null) {
            HashMap<String, String> errorMessageMap = new HashMap<>();
            errorMessageMap.put("message", "Username taken !");

            return new ResponseEntity<>(errorMessageMap, HttpStatus.IM_USED);
        } else {
            if (user.getDoctor() != null) {
                user.setName(repoDoctor.findById(user.getDoctor().getCode()).get().getName());
            } else if (user.getPatient() != null) {
                user.setName(repoPatient.findById(user.getPatient().getCode()).get().getName());
            }
            return ResponseEntity.ok(userDetailsService.save(user));

        }

    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new DisabledException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }
}