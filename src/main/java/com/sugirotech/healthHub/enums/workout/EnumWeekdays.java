package com.sugirotech.healthHub.enums.workout;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.sugirotech.healthHub.enums.users.EnumSex;
import lombok.Getter;

@Getter
public enum EnumWeekdays {
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday"),
    SUNDAY("sunday");

    private final String weekday;

    EnumWeekdays(String weekday) {
        this.weekday=weekday;
    }

    @JsonCreator
    public static EnumWeekdays fromString(String value){
        for(EnumWeekdays weekday : EnumWeekdays.values()){
            if(weekday.name().equalsIgnoreCase(value)){
                return weekday;
            }
        }
        throw new IllegalArgumentException("Invalid weekday: " + value);
    }
}
