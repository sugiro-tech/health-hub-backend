package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.address.AddreesDTO;
import com.sugirotech.healthHub.dtos.address.InAddressDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.repositories.AddressRepository;
import com.sugirotech.healthHub.repositories.UserProfessionalRepository;
import com.sugirotech.healthHub.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfessionalRepository userProfessionalRepository;

    // CONTINUAR

    public AddreesDTO create (InAddressDTO data){
        Address address = new Address(data);

        Optional<User> user = userRepository.findByEmail(data.email_user());

        Optional<UserProfessional> userProfessional = userProfessionalRepository.findByEmail(data.email_user());
        if(userProfessional.isPresent()){
            userProfessional.get().getAddresses().add(new Address(data));
        }

        this.addressRepository.save(address);

        return new AddreesDTO(address);
    }

    public void save(InAddressDTO data){
        addressRepository.save(new Address(data));
    }
}
