package com.abhay.bankease.controller;

import com.abhay.bankease.dto.request.LoginRequest;
import com.abhay.bankease.dto.request.RegisterRequest;
import com.abhay.bankease.dto.response.AuthResponse;
import com.abhay.bankease.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(r));
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest r) {
        return service.login(r);
    }

    @GetMapping("/health")
    public String health() {
        return "BankEase authentication service is running";
    }
}
