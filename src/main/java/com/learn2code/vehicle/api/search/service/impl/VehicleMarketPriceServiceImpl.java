package com.learn2code.vehicle.api.search.service.impl;

import com.learn2code.vehicle.api.search.entity.VehicleMarketPrice;
import com.learn2code.vehicle.api.search.mapper.VehicleMarketPriceMapper;
import com.learn2code.vehicle.api.search.payload.VehicleMarketPriceDto;
import com.learn2code.vehicle.api.search.repository.VehicleMarketPriceRepository;
import com.learn2code.vehicle.api.search.service.VehicleMarketPriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VehicleMarketPriceServiceImpl implements VehicleMarketPriceService {

    private VehicleMarketPriceRepository vehicleMarketPriceRepository;

    private VehicleMarketPriceMapper vehicleMarketPriceMapper;

    @Override
    public VehicleMarketPriceDto saveVehicleMarketPrice(VehicleMarketPriceDto vehicleMarketPriceDto) {
         return vehicleMarketPriceMapper
                .mapToDto(vehicleMarketPriceRepository
                        .save(vehicleMarketPriceMapper.mapToEntity(vehicleMarketPriceDto)));
    }

    @Override
    public VehicleMarketPriceDto getVehicleMarketPriceByBrandName(String brandName, String modelName) {
        return
                vehicleMarketPriceMapper.mapToDto(vehicleMarketPriceRepository.findByBrandNameAndModelName(brandName, modelName));
    }

}
