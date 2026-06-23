package com.agrirakshak.backend.market.service;

import com.agrirakshak.backend.market.entity.MarketPrice;
import com.agrirakshak.backend.market.repository.MarketPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketPriceServiceImpl implements MarketPriceService {

    private final MarketPriceRepository repository;

    @Override
    public MarketPrice addMarketPrice(MarketPrice marketPrice) {
        return repository.save(marketPrice);
    }

    @Override
    public List<MarketPrice> getAllPrices() {
        return repository.findAll();
    }

    @Override
    public List<MarketPrice> getByCrop(String crop) {
        return repository.findByCropIgnoreCase(crop);
    }
}