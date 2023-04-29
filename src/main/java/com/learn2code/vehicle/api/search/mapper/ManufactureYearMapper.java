package com.learn2code.vehicle.api.search.mapper;

import com.learn2code.vehicle.api.search.entity.ManufactureYear;
import com.learn2code.vehicle.api.search.payload.ManufacturerYearDto;

public class ManufactureYearMapper {

    public static ManufacturerYearDto mapToManufacturerYearDto(ManufactureYear manufactureYear) {
        ManufacturerYearDto manufacturerYearDto = new ManufacturerYearDto(
                manufactureYear.getId(),
                manufactureYear.getYear()
        );
        return manufacturerYearDto;
    }

    public static ManufactureYear manufactureYear(ManufacturerYearDto manufacturerYearDto) {
        ManufactureYear manufactureYear = new ManufactureYear(
                manufacturerYearDto.getId(),
                manufacturerYearDto.getYear()
        );
        return manufactureYear;
    }
}
