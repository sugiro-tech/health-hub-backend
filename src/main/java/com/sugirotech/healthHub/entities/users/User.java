package com.sugirotech.healthHub.entities.users;

import com.sugirotech.healthHub.enums.users.EnumRoles;
import com.sugirotech.healthHub.enums.users.EnumSex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user_client")
@AllArgsConstructor
@Getter
@Setter
public class User{
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

    public User(String name, String email, String password,
                String cpf, Integer age, EnumRoles role, EnumSex sex) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.age = age;
        this.role = role;
        this.sex = sex;
    }
}
