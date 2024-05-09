package com.sugirotech.healthHub.entities.users;

import com.sugirotech.healthHub.enums.EnumJobProfessional;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserProfessional extends User{
    private String crn_cref;
    private int rating;
    @Enumerated(EnumType.STRING)
    private EnumJobProfessional job;
}
