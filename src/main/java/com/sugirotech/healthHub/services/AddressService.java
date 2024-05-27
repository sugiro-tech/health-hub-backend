package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.address.AddreesDTO;
import com.sugirotech.healthHub.dtos.address.InAddressDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserService userService;

    // CONTINUAR

    public AddreesDTO create (InAddressDTO data){
        Address address = new Address(data);

        Object user = userService.getByEmail(data.email_user());


        this.addressRepository.save(address);

        return new AddreesDTO(address);
    }

    public void save(InAddressDTO data){
        addressRepository.save(new Address(data));
    }
}
