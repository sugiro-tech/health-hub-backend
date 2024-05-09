package com.sugirotech.healthHub.enums;

public enum EnumRoles {
    ADMIN("admin"),
    CLIENT("client"),
    PROFESSIONAL("professional");

    private String role;

    EnumRoles(String role){
        this.role = role;
    }
}
