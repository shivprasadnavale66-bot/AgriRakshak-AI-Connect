package com.agrirakshak.backend.service;

import com.agrirakshak.backend.entity.Crop;

import java.util.List;

public interface CropService {

    Crop saveCrop(Crop crop);

    List<Crop> getAllCrops();

    Crop getCropById(Long id);

    Crop updateCrop(Long id, Crop crop);

    void deleteCrop(Long id);
}