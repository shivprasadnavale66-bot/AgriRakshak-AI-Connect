package com.agrirakshak.backend.fertilizer.service;

import com.agrirakshak.backend.fertilizer.dto.FertilizerRequest;
import com.agrirakshak.backend.fertilizer.entity.FertilizerRecommendation;

import java.util.List;

public interface FertilizerService {

    FertilizerRecommendation recommend(FertilizerRequest request);

    List<FertilizerRecommendation> getHistory();

}