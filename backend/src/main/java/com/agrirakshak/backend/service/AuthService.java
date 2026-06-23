package com.agrirakshak.backend.service;

import com.agrirakshak.backend.dto.AuthResponse;
import com.agrirakshak.backend.dto.LoginRequest;
import com.agrirakshak.backend.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}