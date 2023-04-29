package com.learn2code.vehicle.api.search.service;

import com.learn2code.vehicle.api.search.payload.ManufacturerDto;

import java.util.List;

public interface ManufacturerService {

    ManufacturerDto saveManufacturer (ManufacturerDto manufacturerDto);

    List<ManufacturerDto> fetchAllManufacturers();
}
