package com.agrirakshak.backend.service;

import com.agrirakshak.backend.dto.DiseaseResponse;
import com.agrirakshak.backend.entity.CropDiseaseReport;
import com.agrirakshak.backend.entity.User;
import com.agrirakshak.backend.repository.CropDiseaseRepository;
import com.agrirakshak.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DiseaseServiceImpl implements DiseaseService {

    private final CropDiseaseRepository diseaseRepository;
    private final UserRepository userRepository;

    private static final String UPLOAD_DIR = "uploads/";

    @Override
    public DiseaseResponse uploadImage(
            @NonNull String email,
            @NonNull String cropName,
            @NonNull MultipartFile file) throws IOException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        Path uploadPath = Paths.get(UPLOAD_DIR);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);

        Files.copy(
                file.getInputStream(),
                filePath,
                StandardCopyOption.REPLACE_EXISTING
        );

        // Dummy AI Prediction (Replace later with Python AI)
        String diseaseName = "Healthy";
        double confidence = 98.7;
        String treatment = "No disease detected. Continue regular crop care.";

        CropDiseaseReport report = CropDiseaseReport.builder()
                .cropName(cropName)
                .diseaseName(diseaseName)
                .confidence(confidence)
                .treatment(treatment)
                .imagePath(filePath.toString())
                .uploadedAt(LocalDateTime.now())
                .user(user)
                .build();

        report = diseaseRepository.save(report);

        return DiseaseResponse.builder()
                .id(report.getId())
                .cropName(report.getCropName())
                .diseaseName(report.getDiseaseName())
                .confidence(report.getConfidence())
                .treatment(report.getTreatment())
                .imagePath(report.getImagePath())
                .uploadedAt(report.getUploadedAt().toString())
                .build();
    }

    @Override
    public List<DiseaseResponse> history(@NonNull String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return diseaseRepository.findByUserOrderByUploadedAtDesc(user)
                .stream()
                .map(report -> DiseaseResponse.builder()
                        .id(report.getId())
                        .cropName(report.getCropName())
                        .diseaseName(report.getDiseaseName())
                        .confidence(report.getConfidence())
                        .treatment(report.getTreatment())
                        .imagePath(report.getImagePath())
                        .uploadedAt(report.getUploadedAt().toString())
                        .build())
                .collect(Collectors.toList());
    }
}