package com.learn2code.vehicle.api.search.mapper;

import com.learn2code.vehicle.api.search.entity.Manufacturer;
import com.learn2code.vehicle.api.search.payload.ManufacturerDto;
import org.mapstruct.Mapper;

@Mapper
public interface ManufacturerMapper {

    ManufacturerDto mapToManufacturerDto(Manufacturer manufacturer);
    Manufacturer mapToManufacturer(ManufacturerDto manufacturerDto);

}
