package com.sugirotech.healthHub.enums.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum EnumJobProfessional {
    NUTRITIONIST("nutritionist"),
    PERSONAL("personal");

    private final String job;

    EnumJobProfessional(String job){
        this.job = job;
    }

    @JsonCreator
    public static EnumJobProfessional fromString(String value){
        for(EnumJobProfessional job : EnumJobProfessional.values()){
            if(job.name().equalsIgnoreCase(value)){
                return job;
            }
        }
        throw new IllegalArgumentException("Invalid job: " + value);
    }
}
