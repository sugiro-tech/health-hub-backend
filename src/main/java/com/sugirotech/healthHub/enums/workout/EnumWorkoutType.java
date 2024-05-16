package com.sugirotech.healthHub.enums.workout;


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
}
