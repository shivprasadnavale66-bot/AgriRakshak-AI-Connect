package com.agrirakshak.backend.controller;

import com.agrirakshak.backend.entity.Crop;
import com.agrirakshak.backend.entity.Farmer;
import com.agrirakshak.backend.repository.CropRepository;
import com.agrirakshak.backend.repository.FarmerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crops")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5500")
public class CropController {

    private final CropRepository cropRepository;
    private final FarmerRepository farmerRepository;

    // ===========================
    // Add Crop
    // ===========================

    @PostMapping
    public ResponseEntity<String> addCrop(@RequestBody Crop crop) {

        if (crop.getFarmer() == null || crop.getFarmer().getId() == null) {
            return ResponseEntity.badRequest().body("Please select a farmer.");
        }

        Optional<Farmer> farmer = farmerRepository.findById(crop.getFarmer().getId());

        if (farmer.isEmpty()) {
            return ResponseEntity.badRequest().body("Farmer not found.");
        }

        crop.setFarmer(farmer.get());

        cropRepository.save(crop);

        return ResponseEntity.ok("Crop added successfully.");
    }

    // ===========================
    // Get All Crops
    // ===========================

    @GetMapping
    public List<Crop> getAllCrops() {

        return cropRepository.findAll();

    }

    // ===========================
    // Get Crop By ID
    // ===========================

    @GetMapping("/{id}")
    public ResponseEntity<Crop> getCropById(@PathVariable Long id) {

        Optional<Crop> crop = cropRepository.findById(id);

        if (crop.isPresent()) {
            return ResponseEntity.ok(crop.get());
        }

        return ResponseEntity.notFound().build();
    }

    // ===========================
    // Update Crop
    // ===========================

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCrop(
            @PathVariable Long id,
            @RequestBody Crop updatedCrop) {

        Optional<Crop> optionalCrop = cropRepository.findById(id);

        if (optionalCrop.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Crop crop = optionalCrop.get();

        crop.setCropName(updatedCrop.getCropName());
        crop.setCropType(updatedCrop.getCropType());
        crop.setSeason(updatedCrop.getSeason());
        crop.setArea(updatedCrop.getArea());
        crop.setSoilType(updatedCrop.getSoilType());

        if (updatedCrop.getFarmer() != null && updatedCrop.getFarmer().getId() != null) {

            Optional<Farmer> farmer = farmerRepository.findById(updatedCrop.getFarmer().getId());

            farmer.ifPresent(crop::setFarmer);
        }

        cropRepository.save(crop);

        return ResponseEntity.ok("Crop updated successfully.");
    }

    // ===========================
    // Delete Crop
    // ===========================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCrop(@PathVariable Long id) {

        if (!cropRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        cropRepository.deleteById(id);

        return ResponseEntity.ok("Crop deleted successfully.");
    }

}