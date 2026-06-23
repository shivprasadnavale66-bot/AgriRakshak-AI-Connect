package com.agrirakshak.backend.service;

import com.agrirakshak.backend.dto.FarmerProfileDto;
import com.agrirakshak.backend.entity.User;
import com.agrirakshak.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmerServiceImpl implements FarmerService {

    private final UserRepository userRepository;

    @Override
    public FarmerProfileDto getProfile(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new FarmerProfileDto(
                user.getFullName(),
                user.getEmail(),
                user.getMobile(),
                user.getVillage(),
                user.getDistrict(),
                user.getState(),
                user.getRole().name()
        );
    }

    @Override
    public FarmerProfileDto updateProfile(String email,
                                          FarmerProfileDto dto) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setFullName(dto.getFullName());
        user.setMobile(dto.getMobile());
        user.setVillage(dto.getVillage());
        user.setDistrict(dto.getDistrict());
        user.setState(dto.getState());

        userRepository.save(user);

        return new FarmerProfileDto(
                user.getFullName(),
                user.getEmail(),
                user.getMobile(),
                user.getVillage(),
                user.getDistrict(),
                user.getState(),
                user.getRole().name()
        );
    }
}