package com.agrirakshak.backend.fertilizer.repository;

import com.agrirakshak.backend.fertilizer.entity.FertilizerRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FertilizerRepository extends JpaRepository<FertilizerRecommendation, Long> {

}