package com.learn2code.vehicle.api.search.repository;

import com.learn2code.vehicle.api.search.entity.VehicleMarketPrice;
import com.learn2code.vehicle.api.search.payload.VehicleMarketPriceDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleMarketPriceRepository extends JpaRepository<VehicleMarketPrice, Integer> {
    VehicleMarketPrice findByBrandNameAndModelName(String brandName, String modelName);
}
