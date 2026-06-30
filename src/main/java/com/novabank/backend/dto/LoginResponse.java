package com.novabank.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

    @Data
    @AllArgsConstructor
    public class LoginResponse {

        private boolean success;
        private String message;

        private Long id;
        private String fullName;
        private String email;

        private Double balance;

        private String accountNumber;

    }

