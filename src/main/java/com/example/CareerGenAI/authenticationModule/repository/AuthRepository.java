package com.example.CareerGenAI.authenticationModule.repository;

import com.example.CareerGenAI.authenticationModule.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Long> {
    AuthEntity findByEmail(String email);
}
