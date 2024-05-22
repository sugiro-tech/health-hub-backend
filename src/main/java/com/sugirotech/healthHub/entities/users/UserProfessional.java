package com.sugirotech.healthHub.entities.users;

import com.sugirotech.healthHub.dtos.users.InUserProfessionalDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.entities.WorkoutPlan;
import com.sugirotech.healthHub.enums.users.EnumJobProfessional;
import com.sugirotech.healthHub.enums.users.EnumRoles;
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

    @OneToOne(mappedBy = "userProfessional", cascade = CascadeType.ALL, orphanRemoval = true)
    private WorkoutPlan workoutPlan;

    //TODO

    public UserProfessional(InUserProfessionalDTO data, String encrypPassword) {
        super(data.name(), data.email(), data.cpf(), data.age(), data.sex(), encrypPassword);
        this.crn_cref = data.crn_cref();
        this.job = data.job();
        this.rating = 0;
        this.setRole(EnumRoles.PROFESSIONAL);
    }
}
