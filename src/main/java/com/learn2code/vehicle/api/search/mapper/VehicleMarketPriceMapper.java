package com.learn2code.vehicle.api.search.mapper;

import com.learn2code.vehicle.api.search.entity.Manufacturer;
import com.learn2code.vehicle.api.search.entity.VehicleMarketPrice;
import com.learn2code.vehicle.api.search.payload.ManufacturerDto;
import com.learn2code.vehicle.api.search.payload.VehicleMarketPriceDto;
import org.mapstruct.Mapper;

@Mapper
public interface VehicleMarketPriceMapper {

    VehicleMarketPriceDto mapToDto(VehicleMarketPrice vehicleMarketPrice);

    VehicleMarketPrice mapToEntity(VehicleMarketPriceDto vehicleMarketPriceDto);
}
