package com.sugirotech.healthHub.enums.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum EnumRoles {
    ADMIN("admin"),
    CLIENT("client"),
    PROFESSIONAL("professional");

    private final String role;

    EnumRoles(String role){
        this.role = role;
    }

    @JsonCreator
    public static EnumRoles fromString(String value){
        for(EnumRoles role : EnumRoles.values()){
            if(role.name().equalsIgnoreCase(value)){
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role: " + value);
    }
}
