package com.learn2code.vehicle.api.search.service;

import com.learn2code.vehicle.api.search.payload.ManufacturerDto;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    ManufacturerDto saveManufacturer (ManufacturerDto manufacturerDto);

    List<ManufacturerDto> fetchAllManufacturers();

    Optional<ManufacturerDto> getManufacturerForId(int id);


}
