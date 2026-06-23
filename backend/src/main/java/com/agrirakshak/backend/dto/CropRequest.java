package com.agrirakshak.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CropRequest {

    @NotBlank(message = "Crop name is required")
    private String cropName;

    @NotBlank(message = "Season is required")
    private String season;

    @NotBlank(message = "Variety is required")
    private String variety;

    @NotNull(message = "Sowing date is required")
    private LocalDate sowingDate;

    @NotNull(message = "Harvest date is required")
    private LocalDate harvestDate;

    @NotNull(message = "Farmer ID is required")
    private Long farmerId;

    public CropRequest() {
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public LocalDate getSowingDate() {
        return sowingDate;
    }

    public void setSowingDate(LocalDate sowingDate) {
        this.sowingDate = sowingDate;
    }

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(LocalDate harvestDate) {
        this.harvestDate = harvestDate;
    }

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }
}