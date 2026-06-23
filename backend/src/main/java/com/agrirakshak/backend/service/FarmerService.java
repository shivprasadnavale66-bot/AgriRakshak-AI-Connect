package com.agrirakshak.backend.service;

import com.agrirakshak.backend.dto.FarmerProfileDto;

public interface FarmerService {

    FarmerProfileDto getProfile(String email);

    FarmerProfileDto updateProfile(String email, FarmerProfileDto dto);

}