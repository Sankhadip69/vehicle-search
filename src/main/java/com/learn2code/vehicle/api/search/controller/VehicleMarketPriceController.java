package com.learn2code.vehicle.api.search.controller;

import com.learn2code.vehicle.api.search.entity.VehicleMarketPrice;
import com.learn2code.vehicle.api.search.payload.VehicleMarketPriceDto;
import com.learn2code.vehicle.api.search.service.VehicleMarketPriceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/vehicle-market-price")
public class VehicleMarketPriceController {

    private VehicleMarketPriceService vehicleMarketPriceService;

    @PostMapping
    public ResponseEntity<VehicleMarketPriceDto> saveVehicleMarketPrice(@RequestBody VehicleMarketPriceDto vehicleMarketPriceDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleMarketPriceService.saveVehicleMarketPrice(vehicleMarketPriceDto));
    }
}
