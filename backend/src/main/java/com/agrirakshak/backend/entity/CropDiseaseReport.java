package com.agrirakshak.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "crop_disease_reports")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CropDiseaseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;

    private String diseaseName;

    private Double confidence;

    @Column(length = 1000)
    private String treatment;

    private String imagePath;

    private LocalDateTime uploadedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}