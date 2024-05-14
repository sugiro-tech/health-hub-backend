package com.sugirotech.healthHub.enums.users;

import lombok.Getter;

@Getter
public enum EnumJobProfessional {
    NUTRITIONIST("nutritionist"),
    PERSONAL("personal");

    private String job;

    EnumJobProfessional(String job){
        this.job = job;
    }
}
