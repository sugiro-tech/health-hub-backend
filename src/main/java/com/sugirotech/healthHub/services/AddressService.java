package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.address.AddreesDTO;
import com.sugirotech.healthHub.dtos.address.InAddressDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddreesDTO create (InAddressDTO data){
        Address address = new Address(data);

        this.addressRepository.save(address);

        return new AddreesDTO(address);
    }
}
