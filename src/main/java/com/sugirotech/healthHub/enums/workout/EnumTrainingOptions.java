package com.sugirotech.healthHub.enums.workout;


import lombok.Getter;

@Getter
public enum EnumTrainingOptions {
    DEFINITION("definition"),
    STRENGTH("strength"),
    HYPERTROPHY("hypertrophy"),
    ENDURANCE("endurance");

    private final String type;

    EnumTrainingOptions(String type){
        this.type = type;
    }
}
