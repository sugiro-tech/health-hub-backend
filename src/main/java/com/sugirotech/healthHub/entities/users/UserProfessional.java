package com.sugirotech.healthHub.entities.users;

import com.sugirotech.healthHub.dtos.users.InUserProfessionalDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.enums.users.EnumJobProfessional;
import com.sugirotech.healthHub.enums.users.EnumRoles;
import com.sugirotech.healthHub.enums.users.EnumSex;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "user_professional")
@Getter
@Setter
public class UserProfessional extends User{
    private String crn_cref;
    private Integer rating;

    @Enumerated(EnumType.STRING)
    private EnumJobProfessional job;

    @ManyToMany(mappedBy = "fk_professional", fetch = FetchType.EAGER)
    private List<Address> fk_address;

    public UserProfessional(String name, String email, String password,
                            String cpf, Integer age, String crn_cref,
                            EnumRoles role, EnumSex sex, Integer rating, EnumJobProfessional job) {
        super(name, email, password, cpf, age, role, sex);
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
