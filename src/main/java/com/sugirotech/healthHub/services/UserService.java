package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.repositories.UserProfessionalRepository;
import com.sugirotech.healthHub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfessionalRepository userProfessionalRepository;

    public UserDetails getByEmail(String email) {

        UserDetails user = userRepository.findByEmail(email);

        if(user == null){
            throw new BadCredentialsException("");
        }

        System.out.println("USUARIO SERVICE - " + user.getUsername());
        return user;
    }

    public void saveProfessional(UserProfessional usuario) {
        this.userProfessionalRepository.save(usuario);
    }

    public void saveClient(User usuario) {
        this.userRepository.save(usuario);
    }
}
