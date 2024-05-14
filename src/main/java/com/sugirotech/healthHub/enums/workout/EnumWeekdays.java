package com.sugirotech.healthHub.enums.workout;

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
}
