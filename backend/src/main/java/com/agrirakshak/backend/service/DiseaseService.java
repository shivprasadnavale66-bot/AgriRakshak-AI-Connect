package com.agrirakshak.backend.service;

import com.agrirakshak.backend.dto.DiseaseResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DiseaseService {

    DiseaseResponse uploadImage(
            String email,
            String cropName,
            MultipartFile file
    ) throws IOException;

    List<DiseaseResponse> history(String email);

}