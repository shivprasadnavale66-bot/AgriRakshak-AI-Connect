package com.agrirakshak.backend.service;

import com.agrirakshak.backend.entity.Crop;
import com.agrirakshak.backend.exception.ResourceNotFoundException;
import com.agrirakshak.backend.repository.CropRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;

    @Override
    public Crop saveCrop(@NonNull Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public Crop getCropById(@NonNull Long id) {
        return cropRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Crop not found with id: " + id));
    }

    @Override
    public Crop updateCrop(@NonNull Long id, @NonNull Crop crop) {

        Crop existingCrop = getCropById(id);

        existingCrop.setCropName(crop.getCropName());
        existingCrop.setCropType(crop.getCropType());
        existingCrop.setSeason(crop.getSeason());
        existingCrop.setArea(crop.getArea());
        existingCrop.setSoilType(crop.getSoilType());

        return cropRepository.save(existingCrop);
    }

    @Override
    public void deleteCrop(@NonNull Long id) {
        Crop crop = getCropById(id);
        cropRepository.delete(crop);
    }
}