package com.agrirakshak.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmerProfileDto {

    private String fullName;
    private String email;
    private String mobile;
    private String village;
    private String district;
    private String state;
    private String role;
}