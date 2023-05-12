package com.learn2code.vehicle.api.search.service;

import com.learn2code.vehicle.api.search.payload.VehicleMarketPriceDto;

public interface VehicleMarketPriceService {

    VehicleMarketPriceDto saveVehicleMarketPrice(VehicleMarketPriceDto vehicleMarketPriceDto);

    VehicleMarketPriceDto getVehicleMarketPriceByBrandName(String brandName, String modelName);
}
