package com.sugirotech.healthHub.dtos.address;

import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.entities.users.UserProfessional;

import java.util.List;

public record AddreesDTO(
        Long id,
        String name,
        String street,
        String neighborhood,
        String city,
        String state,
        Integer number,
        List<UserProfessional> users
){
    public AddreesDTO(Address data) {
        this(data.getId(), data.getName(), data.getStreet(),
                data.getNeighborhood(), data.getCity(), data.getState(),
                data.getNumber(), data.getProfessionals());
    }
}
