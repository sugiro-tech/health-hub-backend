package com.sugirotech.healthHub.entities.users;

import com.sugirotech.healthHub.dtos.users.InUserProfessionalDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.entities.WorkoutPlan;
import com.sugirotech.healthHub.enums.users.EnumJobProfessional;
import com.sugirotech.healthHub.enums.users.EnumRoles;
import com.sugirotech.healthHub.enums.users.EnumSex;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "user_professional")
@Getter
@Setter
public class UserProfessional implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    private String password;
    private String cpf;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private EnumRoles role;

    @Enumerated(EnumType.STRING)
    private EnumSex sex;


    private String crn_cref;
    private Integer rating;

    @Enumerated(EnumType.STRING)
    private EnumJobProfessional job;

    @ManyToMany(mappedBy = "fk_professional", fetch = FetchType.EAGER)
    private List<Address> fk_address;

    @OneToOne(mappedBy = "userProfessional", cascade = CascadeType.ALL, orphanRemoval = true)
    private WorkoutPlan workoutPlan;


    public UserProfessional(InUserProfessionalDTO data, String encrypPassword) {
        this.name = data.name();
        this.email = data.email();
        this.password = encrypPassword;
        this.cpf = data.cpf();
        this.age = data.age();
        this.crn_cref = data.crn_cref();
        this.sex = data.sex();
        this.job = data.job();
        this.rating = 0;
        this.role = EnumRoles.PROFESSIONAL;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role ==  EnumRoles.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_CLIENT"), new SimpleGrantedAuthority("ROLE_PROFESSIONAL"));

        else if (this.role == EnumRoles.CLIENT) return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));

        else return List.of(new SimpleGrantedAuthority("ROLE_PROFESSIONAL"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
