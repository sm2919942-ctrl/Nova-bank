package com.novabank.backend.entity;

import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(name = "users")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor

    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String fullName;

        @Column(unique = true)
        private String email;

        private String mobile;
        private String dob;
        private String gender;
        private String accountType;
        private String address;

        @Column(unique = true)
        private String aadhaar;

        @Column(unique = true)
        private String pan;

        private String password;

        private Double balance = 0.0;
        private String accountNumber;
        private String customerId;
        private String ifscCode;
        private String accountStatus;
        private String createdAt;
    }


