package com.novabank.backend.dto;

import lombok.Data;

    @Data
    public class RegisterRequest {

        private String fullName;

        private String email;

        private String mobile;

        private String dob;

        private String gender;

        private String accountType;

        private String address;

        private String aadhaar;

        private String pan;

        private String password;

    }

