package com.sugirotech.healthHub.dtos;

import com.sugirotech.healthHub.entities.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record InAddressDTO(
        @NotBlank
        String name,
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @Positive
        Integer number
) {
        public InAddressDTO(Address address){
                this(address.getName(), address.getStreet(),
                        address.getNeighborhood(), address.getCity(),
                        address.getState(), address.getNumber());
        }
}
