package com.sugirotech.healthHub.repositories;

import com.sugirotech.healthHub.entities.users.UserProfessional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfessionalRepository extends JpaRepository<UserProfessional, Long> {
    Optional<UserProfessional> findByEmail(String email);

}
