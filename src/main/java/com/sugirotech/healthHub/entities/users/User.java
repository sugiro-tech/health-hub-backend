package com.sugirotech.healthHub.entities.users;

import com.sugirotech.healthHub.dtos.users.InUserDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.entities.WorkoutPlan;
import com.sugirotech.healthHub.enums.users.EnumRoles;
import com.sugirotech.healthHub.enums.users.EnumSex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "user_client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements UserDetails {
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

    // TODO REVER ONE TO ONE

    @OneToMany(mappedBy = "userClient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WorkoutPlan> workoutPlans = new HashSet<>();

    @ManyToMany(mappedBy = "clients", fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();


    public User(InUserDTO dados, String encrypPassword) {
        this.name = dados.name();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.age = dados.age();
        this.sex = dados.sex();
        this.password = encrypPassword;
        this.role = EnumRoles.CLIENT;
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
    public String getPassword() {
        return this.password;
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
