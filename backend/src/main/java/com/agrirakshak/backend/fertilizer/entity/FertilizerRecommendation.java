package com.agrirakshak.backend.fertilizer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fertilizer_recommendations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FertilizerRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crop;

    private String soilType;

    private int nitrogen;

    private int phosphorus;

    private int potassium;

    @Column(length = 1000)
    private String recommendation;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}