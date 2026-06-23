package com.agrirakshak.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private boolean success;
    private String message;
    private String token;      // JWT token (can be null for now)
    private String role;
    private String fullName;
    private String email;
}