package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.address.AddressDTO;
import com.sugirotech.healthHub.dtos.address.InAddressDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import com.sugirotech.healthHub.repositories.AddressRepository;
import com.sugirotech.healthHub.repositories.UserProfessionalRepository;
import com.sugirotech.healthHub.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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


    @Transactional
    public AddressDTO create (InAddressDTO data){

        Address address = new Address(data);

        Optional<UserProfessional> userProfessional = userProfessionalRepository.findByEmail(data.email_user());

        if(userProfessional.isPresent()){
            UserProfessional existingUserProfessional = userProfessional.get();

            existingUserProfessional.getAddresses().add(address);
            address.getProfessionals().add(existingUserProfessional);

            this.userProfessionalRepository.save(existingUserProfessional);
            this.addressRepository.save(address);

            return new AddressDTO(address);
        }

        Optional<User> user = userRepository.findByEmail(data.email_user());

        if(user.isPresent()){
            User existingUser = user.get();

            existingUser.getAddresses().add(address);
            address.getClients().add(existingUser);

            this.userRepository.save(existingUser);
            this.addressRepository.save(address);

            return new AddressDTO(address);
        }
        throw new NotFoundException("Client/Professional not found!");
    }


    public void save(InAddressDTO data){
        addressRepository.save(new Address(data));
    }
}
