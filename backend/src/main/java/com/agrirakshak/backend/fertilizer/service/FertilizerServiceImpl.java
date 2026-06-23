package com.agrirakshak.backend.fertilizer.service;

import com.agrirakshak.backend.fertilizer.dto.FertilizerRequest;
import com.agrirakshak.backend.fertilizer.entity.FertilizerRecommendation;
import com.agrirakshak.backend.fertilizer.repository.FertilizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FertilizerServiceImpl implements FertilizerService {

    private final FertilizerRepository repository;

    @Override
    public FertilizerRecommendation recommend(FertilizerRequest request) {

        String recommendation = generateRecommendation(
                request.getNitrogen(),
                request.getPhosphorus(),
                request.getPotassium()
        );

        FertilizerRecommendation fertilizer = FertilizerRecommendation.builder()
                .crop(request.getCrop())
                .soilType(request.getSoilType())
                .nitrogen(request.getNitrogen())
                .phosphorus(request.getPhosphorus())
                .potassium(request.getPotassium())
                .recommendation(recommendation)
                .build();

        return repository.save(fertilizer);
    }

    @Override
    public List<FertilizerRecommendation> getHistory() {
        return repository.findAll();
    }

    private String generateRecommendation(int n, int p, int k) {

        if (n < 50 && p < 40 && k < 40) {
            return "Nitrogen, Phosphorus and Potassium are low. Apply a balanced NPK fertilizer (10:26:26 or 12:32:16) along with Urea as recommended.";
        }

        if (n < 50) {
            return "Nitrogen is low. Apply Urea or Ammonium Sulphate.";
        }

        if (p < 40) {
            return "Phosphorus is low. Apply DAP (Diammonium Phosphate).";
        }

        if (k < 40) {
            return "Potassium is low. Apply MOP (Muriate of Potash).";
        }

        return "Soil nutrients are balanced. Use NPK 20:20:20 fertilizer for maintenance.";
    }
}