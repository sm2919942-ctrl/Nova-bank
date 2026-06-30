package com.novabank.backend.controller;

import com.novabank.backend.dto.RegisterRequest;
import com.novabank.backend.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.novabank.backend.dto.ApiResponse;
import com.novabank.backend.dto.LoginRequest;
import com.novabank.backend.dto.LoginResponse;

    @RestController
    @RequestMapping("/api/users")
    @CrossOrigin(origins = "*")
    public class UserController {

        private final UserService service;

        public UserController(UserService service) {
            this.service = service;
        }

        @PostMapping("/register")
        public ApiResponse register(@RequestBody RegisterRequest request) {

            return service.register(request);

        }
        @PostMapping("/login")
        public LoginResponse login(@RequestBody LoginRequest request) {

            return service.login(request);

        }

    }

