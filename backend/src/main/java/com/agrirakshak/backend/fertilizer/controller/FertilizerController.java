package com.agrirakshak.backend.fertilizer.controller;

import com.agrirakshak.backend.fertilizer.dto.FertilizerRequest;
import com.agrirakshak.backend.fertilizer.entity.FertilizerRecommendation;
import com.agrirakshak.backend.fertilizer.service.FertilizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fertilizer")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5500")
public class FertilizerController {

    private final FertilizerService fertilizerService;

    @PostMapping("/recommend")
    public FertilizerRecommendation recommend(
            @RequestBody FertilizerRequest request) {

        return fertilizerService.recommend(request);
    }

    @GetMapping("/history")
    public List<FertilizerRecommendation> history() {

        return fertilizerService.getHistory();
    }
}