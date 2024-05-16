package com.sugirotech.healthHub.entities;

import com.sugirotech.healthHub.dtos.InAddressDTO;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private Integer number;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "professional_address", joinColumns = @JoinColumn(name = "fk_address"),
    inverseJoinColumns = @JoinColumn(name = "fk_professional"))
    private List<UserProfessional> fk_professional;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "client_address", joinColumns = @JoinColumn(name = "fk_address"),
    inverseJoinColumns = @JoinColumn(name = "fk_client"))
    private List<User> fk_client;

    public Address(InAddressDTO data) {
        this.name = data.name();
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.city = data.city();
        this.state = data.state();
        this.number = data.number();
    }
}
