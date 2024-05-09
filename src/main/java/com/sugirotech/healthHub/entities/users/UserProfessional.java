package com.sugirotech.healthHub.entities.users;

import com.sugirotech.healthHub.dtos.users.InUserProfessionalDTO;
import com.sugirotech.healthHub.enums.EnumJobProfessional;
import com.sugirotech.healthHub.enums.EnumRoles;
import com.sugirotech.healthHub.enums.EnumSex;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "User_Professional")
@Getter
@Setter
public class UserProfessional extends User{
    private String crn_cref;
    private Integer rating;
    @Enumerated(EnumType.STRING)
    private EnumJobProfessional job;

    public UserProfessional(Long id, String name, String email, String password,
                            String cpf, Integer age, String crn_cref,
                            EnumRoles role, EnumSex sex, Integer rating, EnumJobProfessional job) {
        super(id, name, email, password, cpf, age, role, sex);
        this.crn_cref = crn_cref;
        this.rating = rating;
        this.job = job;
    }

    // Construtor utilizando DTO

    public UserProfessional(InUserProfessionalDTO data){
        super(data.name(), data.email(), data.password(), data.cpf(), data.age(),
        data.role(), data.sex());

        this.crn_cref = data.crn_cref();
        this.job = data.job();
        this.rating = 0;
    }
}
