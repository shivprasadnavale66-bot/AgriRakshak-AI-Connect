package com.agrirakshak.backend.market.service;

import com.agrirakshak.backend.market.entity.MarketPrice;

import java.util.List;

public interface MarketPriceService {

    MarketPrice addMarketPrice(MarketPrice marketPrice);

    List<MarketPrice> getAllPrices();

    List<MarketPrice> getByCrop(String crop);

}