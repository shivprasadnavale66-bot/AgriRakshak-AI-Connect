package com.agrirakshak.backend.market.controller;

import com.agrirakshak.backend.market.entity.MarketPrice;
import com.agrirakshak.backend.market.service.MarketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/market")
@RequiredArgsConstructor
public class MarketPriceController {

    private final MarketPriceService service;

    @PostMapping("/add")
    public MarketPrice add(@RequestBody MarketPrice marketPrice) {
        return service.addMarketPrice(marketPrice);
    }

    @GetMapping("/all")
    public List<MarketPrice> getAll() {
        return service.getAllPrices();
    }

    @GetMapping("/{crop}")
    public List<MarketPrice> getByCrop(@PathVariable String crop) {
        return service.getByCrop(crop);
    }
}