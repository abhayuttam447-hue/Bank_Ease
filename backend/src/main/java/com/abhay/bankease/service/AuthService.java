package com.abhay.bankease.service;

import com.abhay.bankease.dto.request.LoginRequest;
import com.abhay.bankease.dto.request.RegisterRequest;
import com.abhay.bankease.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}