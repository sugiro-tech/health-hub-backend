package com.sugirotech.healthHub.enums;

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

    private String weekday;

    EnumWeekdays(String weekday) {
        this.weekday=weekday;
    }
}
