package com.agrirakshak.backend.fertilizer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FertilizerRequest {

    private String crop;

    private String soilType;

    private int nitrogen;

    private int phosphorus;

    private int potassium;

}