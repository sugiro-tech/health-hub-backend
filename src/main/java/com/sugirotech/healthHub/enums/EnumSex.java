package com.sugirotech.healthHub.enums;

import lombok.Getter;

@Getter
public enum EnumSex {
    MALE("male"),
    FEMALE("female"),
    OTHERS("others");

    private String sex;

    EnumSex(String sex) {
        this.sex = sex;
    }
}
