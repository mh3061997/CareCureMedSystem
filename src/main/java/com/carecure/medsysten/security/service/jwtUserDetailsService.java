package com.carecure.medsysten.security.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.carecure.medsysten.security.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class jwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private com.carecure.medsysten.security.models.roleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDao user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new userDetails(user);
    }

    public UserDao save(userDtoRegister user) {
        UserDao newUser = new UserDao();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setPatient(user.getPatient());
        newUser.setDoctor(user.getDoctor());
        newUser.setName(user.getName());
        Set<role> roles = new HashSet<>();
        user.getRoles().forEach(role->{
            role roleDB = roleRepository.findByname(role.getName());
            roles.add(roleDB);
        });
        newUser.setRoles(roles);
        return userRepository.save(newUser);
    }

}