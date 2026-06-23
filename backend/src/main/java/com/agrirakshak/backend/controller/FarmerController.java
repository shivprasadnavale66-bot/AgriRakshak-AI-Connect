package com.agrirakshak.backend.controller;

import com.agrirakshak.backend.dto.FarmerProfileDto;
import com.agrirakshak.backend.entity.Farmer;
import com.agrirakshak.backend.repository.FarmerRepository;
import com.agrirakshak.backend.service.FarmerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/farmer")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5500")
public class FarmerController {

    private final FarmerService farmerService;
    private final FarmerRepository farmerRepository;

    // ===========================
    // Farmer Profile
    // ===========================

    @GetMapping("/profile")
    public FarmerProfileDto getProfile(Authentication authentication) {
        return farmerService.getProfile(authentication.getName());
    }

    @PutMapping("/profile")
    public FarmerProfileDto updateProfile(
            Authentication authentication,
            @RequestBody FarmerProfileDto dto) {

        return farmerService.updateProfile(
                authentication.getName(),
                dto
        );
    }

    // ===========================
    // Add Farmer
    // ===========================

    @PostMapping
    public ResponseEntity<String> addFarmer(@RequestBody Farmer farmer) {

        farmerRepository.save(farmer);

        return ResponseEntity.ok("Farmer added successfully");
    }

    // ===========================
    // Get All Farmers
    // ===========================

    @GetMapping
    public List<Farmer> getAllFarmers() {

        return farmerRepository.findAll();

    }

    // ===========================
    // Get Farmer By ID
    // ===========================

    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getFarmerById(@PathVariable Long id) {

        Optional<Farmer> farmer = farmerRepository.findById(id);

        if (farmer.isPresent()) {
            return ResponseEntity.ok(farmer.get());
        }

        return ResponseEntity.notFound().build();
    }

    // ===========================
    // Update Farmer
    // ===========================

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFarmer(
            @PathVariable Long id,
            @RequestBody Farmer updatedFarmer) {

        Optional<Farmer> optionalFarmer = farmerRepository.findById(id);

        if (optionalFarmer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Farmer farmer = optionalFarmer.get();

        farmer.setFullName(updatedFarmer.getFullName());
        farmer.setVillage(updatedFarmer.getVillage());
        farmer.setDistrict(updatedFarmer.getDistrict());
        farmer.setState(updatedFarmer.getState());
        farmer.setMobileNumber(updatedFarmer.getMobileNumber());
        farmer.setLandArea(updatedFarmer.getLandArea());
        farmer.setSoilType(updatedFarmer.getSoilType());
        farmer.setWaterSource(updatedFarmer.getWaterSource());

        farmerRepository.save(farmer);

        return ResponseEntity.ok("Farmer updated successfully");
    }

    // ===========================
    // Delete Farmer
    // ===========================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFarmer(@PathVariable Long id) {

        if (!farmerRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        farmerRepository.deleteById(id);

        return ResponseEntity.ok("Farmer deleted successfully");
    }
}