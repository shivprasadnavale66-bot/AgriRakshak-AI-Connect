package com.agrirakshak.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "farmers")
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String village;
    private String district;
    private String state;
    private String mobileNumber;
    private Double landArea;
    private String soilType;
    private String waterSource;

    public Farmer() {
    }

    public Farmer(Long id, String fullName, String village, String district, String state,
                  String mobileNumber, Double landArea, String soilType, String waterSource) {
        this.id = id;
        this.fullName = fullName;
        this.village = village;
        this.district = district;
        this.state = state;
        this.mobileNumber = mobileNumber;
        this.landArea = landArea;
        this.soilType = soilType;
        this.waterSource = waterSource;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Double getLandArea() {
        return landArea;
    }

    public void setLandArea(Double landArea) {
        this.landArea = landArea;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }

    public String getWaterSource() {
        return waterSource;
    }

    public void setWaterSource(String waterSource) {
        this.waterSource = waterSource;
    }
}