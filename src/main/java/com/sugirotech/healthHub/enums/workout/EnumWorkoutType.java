package com.sugirotech.healthHub.enums.workout;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.sugirotech.healthHub.enums.users.EnumSex;
import lombok.Getter;

@Getter
public enum EnumWorkoutType{
    DEFINITION("definition"),
    STRENGTH("strength"),
    HYPERTROPHY("hypertrophy"),
    ENDURANCE("endurance");

    private final String type;

    EnumWorkoutType(String type){
        this.type = type;
    }

    @JsonCreator
    public static EnumWorkoutType fromString(String value){
        for(EnumWorkoutType type : EnumWorkoutType.values()){
            if(type.name().equalsIgnoreCase(value)){
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid sex: " + value);
    }
}
