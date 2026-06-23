package com.agrirakshak.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiseaseResponse {

    private Long id;

    private String cropName;

    private String diseaseName;

    private Double confidence;

    private String treatment;

    private String imagePath;

    private String uploadedAt;
}