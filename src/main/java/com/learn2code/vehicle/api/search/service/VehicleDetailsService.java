package com.learn2code.vehicle.api.search.service;

import com.learn2code.vehicle.api.search.payload.ClientVehicleDetailsDto;
import com.learn2code.vehicle.api.search.payload.VehicleDetailDto;

import java.util.List;

public interface VehicleDetailsService {

   List<ClientVehicleDetailsDto> getAllVehicleDetails();

   VehicleDetailDto getVehicleById(int vehicleId);


    List<ClientVehicleDetailsDto> fetchVehicleDetailsByCriteria(String modelYear, String brandName, String modelName, String trimType, double price);
}
