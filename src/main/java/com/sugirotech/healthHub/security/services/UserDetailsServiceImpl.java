package com.sugirotech.healthHub.security.services;

import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.repositories.UserProfessionalRepository;
import com.sugirotech.healthHub.repositories.UserRepository;
import com.sugirotech.healthHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserProfessionalRepository userProfessionalRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()){
            return user.get();
        }

        Optional<UserProfessional> userProfessional = userProfessionalRepository.findByEmail(email);

        if(userProfessional.isPresent()){
            return userProfessional.get();
        }

        throw new UsernameNotFoundException("User not found: " + email);

    }
}
