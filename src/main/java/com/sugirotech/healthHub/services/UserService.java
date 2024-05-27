package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.address.InAddressDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.repositories.UserProfessionalRepository;
import com.sugirotech.healthHub.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfessionalRepository userProfessionalRepository;

    // Retorna tipo de usuario

    public boolean isClient(String email){
        return userRepository.findByEmail(email).isPresent();
    }

    // saves

    public void saveProfessional(UserProfessional usuario) {
        this.userProfessionalRepository.save(usuario);
    }

    public void saveClient(User usuario) {
        this.userRepository.save(usuario);
    }

    // GET BY EMAIL

    public Object getByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()){
            return  user.get();
        }

        Optional<UserProfessional> userProfessional = userProfessionalRepository.findByEmail(email);
        if(userProfessional.isPresent()){
            return userProfessional.get();
        }

        throw new UsernameNotFoundException("User not found " + email);
    }
}
