package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails getByEmail(String email) {

        UserDetails user = userRepository.findByEmail(email);

        if(user == null){
            throw new BadCredentialsException("");
        }

        System.out.println("USUARIO SERVICE - " + user.getUsername());
        return user;
    }
}
