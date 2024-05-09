package com.sugirotech.healthHub.entities.users;

import com.sugirotech.healthHub.enums.EnumJobProfessional;
import com.sugirotech.healthHub.enums.EnumRoles;
import com.sugirotech.healthHub.enums.EnumSex;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;


@Entity
@Table(name = "User_Professional")
public class UserProfessional extends User{
    private String crn_cref;
    private int rating;
    @Enumerated(EnumType.STRING)
    private EnumJobProfessional job;

    public UserProfessional(Long id, String name, String email, String password,
                            String cep, Integer age, String crn_cref,
                            EnumRoles role, EnumSex sex, int rating, EnumJobProfessional job) {
        super(id, name, email, password, cep, age, role, sex);
        this.crn_cref = crn_cref;
        this.rating = rating;
        this.job = job;
    }
}
