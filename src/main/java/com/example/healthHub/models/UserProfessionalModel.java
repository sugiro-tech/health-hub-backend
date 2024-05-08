package com.example.healthHub.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TB_Professional")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserProfessionalModel implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.roles == UserProfessionalModel.Roles.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_CLIENT"), new SimpleGrantedAuthority("ROLE_PROFESSIONAL"));
        else if(this.roles == UserProfessionalModel.Roles.CLIENT) return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"));
        else return List.of(new SimpleGrantedAuthority("ROLE_CLIENT"), new SimpleGrantedAuthority("ROLE_PROFESSIONAL"));

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    public enum Sexo{
        masculino("masculino"),
        feminino("feminino"),
        naodeclarar("não declarar");

        public final String sexo;

        private Sexo(String label) {
            this.sexo = label;
        }
    }
    public enum Roles{
        ADMIN("ADMIN"),
        CLIENT("CLIENT"),
        PROFESSIONAL("PROFESSIONAL");

        public final String role;

        private Roles(String label) {
            this.role = label;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Sexo gender;
    private String crn_cref;
    private String job;
    private Double rating;
    @ManyToMany(mappedBy = "fk_professional", fetch = FetchType.EAGER)
    private List<AddressModel> fk_address;
    private UserProfessionalModel.Roles roles;
    private String email;
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sexo getGender() {
        return gender;
    }

    public void setGender(Sexo gender) {
        this.gender = gender;
    }

    public String getCrn_cref() {
        return crn_cref;
    }

    public void setCrn_cref(String crn_cref) {
        this.crn_cref = crn_cref;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<AddressModel> getFk_address() {
        return fk_address;
    }

    public void setFk_address(List<AddressModel> fk_address) {
        this.fk_address = fk_address;
    }

    public UserProfessionalModel.Roles getRoles() {
        return roles;
    }

    public void setRoles(UserProfessionalModel.Roles roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
