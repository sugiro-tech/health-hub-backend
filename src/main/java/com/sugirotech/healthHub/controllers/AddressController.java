package com.sugirotech.healthHub.controllers;

import com.sugirotech.healthHub.dtos.InAddressDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.services.AddressService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    @Transactional
    public ResponseEntity<InAddressDTO> create (@RequestBody @Valid InAddressDTO data, UriComponentsBuilder uriBuilder){
        Address address = new Address(data);

        var uri = uriBuilder.path("/address/{id}").buildAndExpand(address.getId()).toUri();

        return ResponseEntity.created(uri).body(addressService.create(new InAddressDTO(address)));
    }
}
