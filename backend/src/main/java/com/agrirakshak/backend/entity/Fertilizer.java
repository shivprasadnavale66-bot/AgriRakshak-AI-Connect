package com.agrirakshak.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fertilizers")
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fertilizerName;

    private String fertilizerType;

    private Double quantity;

    private String unit;

    private String applicationDate;

    public Fertilizer() {
    }

    public Fertilizer(Long id, String fertilizerName, String fertilizerType,
                      Double quantity, String unit, String applicationDate) {
        this.id = id;
        this.fertilizerName = fertilizerName;
        this.fertilizerType = fertilizerType;
        this.quantity = quantity;
        this.unit = unit;
        this.applicationDate = applicationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFertilizerName() {
        return fertilizerName;
    }

    public void setFertilizerName(String fertilizerName) {
        this.fertilizerName = fertilizerName;
    }

    public String getFertilizerType() {
        return fertilizerType;
    }

    public void setFertilizerType(String fertilizerType) {
        this.fertilizerType = fertilizerType;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }
}