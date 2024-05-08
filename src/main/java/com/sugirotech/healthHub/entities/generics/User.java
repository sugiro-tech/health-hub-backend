package com.sugirotech.healthHub.entities.generics;

import com.sugirotech.healthHub.enums.EnumSex;
import jakarta.persistence.*;


public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String cep;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private EnumSex sex;
}
