package com.sugirotech.healthHub.repositories;

import com.sugirotech.healthHub.entities.users.UserProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserProfessionalRepository extends JpaRepository<UserProfessional, Long> {
    UserDetails findByEmail(String email);

}
