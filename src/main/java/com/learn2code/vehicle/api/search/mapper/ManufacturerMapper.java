package com.learn2code.vehicle.api.search.mapper;

import com.learn2code.vehicle.api.search.entity.Manufacturer;
import com.learn2code.vehicle.api.search.payload.ManufacturerDto;

public class ManufacturerMapper {

    public static ManufacturerDto mapToManufactureDto(Manufacturer manufacturer) {
        ManufacturerDto manufacturerDto = new ManufacturerDto(
          manufacturer.getId(),
          manufacturer.getManufacturerName(),
          manufacturer.getCountryOfOrigin()
        );
        return manufacturerDto;
    }

    public static Manufacturer mapToManufacturer(ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = new Manufacturer(
          manufacturerDto.getId(),
          manufacturerDto.getManufacturerName(),
          manufacturerDto.getCountryOfOrigin()
        );
        return manufacturer;
    }
}
