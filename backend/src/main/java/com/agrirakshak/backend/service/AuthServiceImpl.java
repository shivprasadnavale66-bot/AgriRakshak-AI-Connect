package com.agrirakshak.backend.service;

import com.agrirakshak.backend.dto.AuthResponse;
import com.agrirakshak.backend.dto.LoginRequest;
import com.agrirakshak.backend.dto.RegisterRequest;
import com.agrirakshak.backend.entity.Role;
import com.agrirakshak.backend.entity.User;
import com.agrirakshak.backend.repository.UserRepository;
import com.agrirakshak.backend.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            return new AuthResponse(
                    false,
                    "Email already exists",
                    null,
                    null,
                    null,
                    request.getEmail()
            );
        }

        if (userRepository.existsByMobile(request.getMobile())) {
            return new AuthResponse(
                    false,
                    "Mobile number already exists",
                    null,
                    null,
                    null,
                    request.getEmail()
            );
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setMobile(request.getMobile());

        user.setVillage(request.getVillage());
        user.setDistrict(request.getDistrict());
        user.setState(request.getState());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (request.getRole() != null &&
                request.getRole().equalsIgnoreCase("ADMIN")) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.FARMER);
        }

        userRepository.save(user);

        // Generate JWT
        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(
                true,
                "Registration Successful",
                token,
                user.getRole().name(),
                user.getFullName(),
                user.getEmail()
        );
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            return new AuthResponse(
                    false,
                    "User not found",
                    null,
                    null,
                    null,
                    request.getEmail()
            );
        }

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            return new AuthResponse(
                    false,
                    "Incorrect Password",
                    null,
                    null,
                    null,
                    request.getEmail()
            );
        }

        // Generate JWT
        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(
                true,
                "Login Successful",
                token,
                user.getRole().name(),
                user.getFullName(),
                user.getEmail()
        );
    }
}