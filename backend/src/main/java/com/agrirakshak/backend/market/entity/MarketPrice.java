package com.agrirakshak.backend.market.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "market_prices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String crop;

    private String state;

    private String district;

    private String market;

    private double minPrice;

    private double maxPrice;

    private double modalPrice;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}