package com.novabank.backend.service;

import com.novabank.backend.dto.RegisterRequest;
import com.novabank.backend.entity.User;
import com.novabank.backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.novabank.backend.dto.ApiResponse;
import com.novabank.backend.dto.LoginRequest;
import com.novabank.backend.dto.LoginResponse;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.novabank.backend.entity.Role;


    @Service
    public class UserService {

        private final UserRepository repository;
        private final BCryptPasswordEncoder passwordEncoder;

        public UserService(UserRepository repository,
                           BCryptPasswordEncoder passwordEncoder) {

            this.repository = repository;
            this.passwordEncoder = passwordEncoder;

        }

        public ApiResponse register(RegisterRequest request) {


            if (repository.existsByEmail(request.getEmail())) {
                return new ApiResponse(false, "Email already exists.");
            }

            if (repository.existsByAadhaar(request.getAadhaar())) {
                return new ApiResponse(false, "Aadhaar already exists.");
            }


            if (repository.existsByPan(request.getPan())) {
                return new ApiResponse(false, "PAN already exists.");
            }

            User user = new User();

            user.setFullName(request.getFullName());
            user.setEmail(request.getEmail());
            user.setMobile(request.getMobile());
            user.setDob(request.getDob());
            user.setGender(request.getGender());
            user.setAccountType(request.getAccountType());
            user.setAddress(request.getAddress());
            user.setAadhaar(request.getAadhaar());
            user.setPan(request.getPan());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setBalance(0.0);

            // Default balance
            user.setBalance(0.0);

            repository.save(user);

            user.setRole(Role.USER);
            return new ApiResponse(true, "Registration Successful");
        }

        public LoginResponse login(LoginRequest request) {

            User user = repository.findByEmail(request.getEmail()).orElse(null);

            if (user == null) {
                return new LoginResponse(
                        false,
                        "Email not found",
                        null,
                        null,
                        null,
                        null,
                        null
                );
            }

            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return new LoginResponse(
                        false,
                        "Invalid Password",
                        null,
                        null,
                        null,
                        null,
                        null
                );

            }

            return new LoginResponse(
                    true,
                    "Login Successful",
                    user.getId(),
                    user.getFullName(),
                    user.getEmail(),
                    user.getBalance(),
                    user.getAccountNumber()
            );
        }

    }



