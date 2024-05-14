package com.sugirotech.healthHub.enums.users;

import lombok.Getter;

@Getter
public enum EnumRoles {
    ADMIN("admin"),
    CLIENT("client"),
    PROFESSIONAL("professional");

    private String role;

    EnumRoles(String role){
        this.role = role;
    }
}
