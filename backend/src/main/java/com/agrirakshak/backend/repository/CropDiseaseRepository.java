package com.agrirakshak.backend.repository;

import com.agrirakshak.backend.entity.CropDiseaseReport;
import com.agrirakshak.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropDiseaseRepository extends JpaRepository<CropDiseaseReport, Long> {

    List<CropDiseaseReport> findByUserOrderByUploadedAtDesc(User user);

}