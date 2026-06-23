package com.agrirakshak.backend.controller;

import com.agrirakshak.backend.dto.DiseaseResponse;
import com.agrirakshak.backend.service.DiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/disease")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5500")
public class DiseaseController {

    private final DiseaseService diseaseService;

    @PostMapping("/upload")
    public DiseaseResponse uploadImage(
            Authentication authentication,
            @RequestParam("cropName") String cropName,
            @RequestParam("image") MultipartFile image
    ) throws IOException {

        return diseaseService.uploadImage(
                authentication.getName(),
                cropName,
                image
        );
    }

    @GetMapping("/history")
    public List<DiseaseResponse> history(
            Authentication authentication
    ) {

        return diseaseService.history(authentication.getName());
    }
}