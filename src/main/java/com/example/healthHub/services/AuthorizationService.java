package com.example.healthHub.services;

import com.example.healthHub.repositories.UserClientRepository;
import com.example.healthHub.repositories.UserProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {
    @Autowired
    UserClientRepository userClientRepository;
    @Autowired
    UserProfessionalRepository userProfessionalRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userClientRepository.findByEmail(username);
        if (user != null) {
            return user;
        }else{
            user = userProfessionalRepository.findByEmail(username);
            return user;
        }
    }
}
