package com.sugirotech.healthHub.repositories;

import com.sugirotech.healthHub.entities.users.UserProfessional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfessionalRepository extends JpaRepository<UserProfessional, Long> {
}
