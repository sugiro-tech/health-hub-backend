package com.sugirotech.healthHub.enums.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum EnumSex {
    MALE("male"),
    FEMALE("female"),
    OTHERS("others");

    private final String sex;

    EnumSex(String sex) {
        this.sex = sex;
    }

    @JsonCreator
    public static EnumSex fromString(String value){
        for(EnumSex sex : EnumSex.values()){
            if(sex.name().equalsIgnoreCase(value)){
                return sex;
            }
        }
        throw new IllegalArgumentException("Invalid sex: " + value);
    }
}
