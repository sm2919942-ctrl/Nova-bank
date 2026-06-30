package com.novabank.backend.repository;

import com.novabank.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

    @Repository
    public interface UserRepository extends JpaRepository<User, Long> {

        Optional<User> findByEmail(String email);

        boolean existsByEmail(String email);

        boolean existsByAadhaar(String aadhaar);

        boolean existsByPan(String pan);

    }

