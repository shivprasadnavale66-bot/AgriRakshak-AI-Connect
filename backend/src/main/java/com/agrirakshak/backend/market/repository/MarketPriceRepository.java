package com.agrirakshak.backend.market.repository;

import com.agrirakshak.backend.market.entity.MarketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketPriceRepository extends JpaRepository<MarketPrice, Long> {

    List<MarketPrice> findByCropIgnoreCase(String crop);

}