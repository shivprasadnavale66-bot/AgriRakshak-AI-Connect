package com.agrirakshak.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;

    private String cropType;

    private String season;

    private Double area;

    private String soilType;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    public Crop() {
    }

    public Crop(Long id, String cropName, String cropType, String season,
                Double area, String soilType, Farmer farmer) {
        this.id = id;
        this.cropName = cropName;
        this.cropType = cropType;
        this.season = season;
        this.area = area;
        this.soilType = soilType;
        this.farmer = farmer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }
}