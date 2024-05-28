package com.sugirotech.healthHub.dtos.address;

import com.sugirotech.healthHub.entities.Address;


public record AddressDTO(
        Long id,
        String name,
        String street,
        String neighborhood,
        String city,
        String state,
        Integer number
){
    public AddressDTO(Address data) {
        this(data.getId(), data.getName(), data.getStreet(),
                data.getNeighborhood(), data.getCity(), data.getState(),
                data.getNumber());
    }
}
