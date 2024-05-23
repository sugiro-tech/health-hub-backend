package com.sugirotech.healthHub.repositories;

import com.sugirotech.healthHub.entities.users.UserProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserProfessionalRepository extends JpaRepository<UserProfessional, Long> {
    Optional<UserProfessional> findByEmail(String email);

}
