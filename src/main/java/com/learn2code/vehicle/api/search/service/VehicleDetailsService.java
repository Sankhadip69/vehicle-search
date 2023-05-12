package com.learn2code.vehicle.api.search.service;

import com.learn2code.vehicle.api.search.payload.ClientVehicleDetailsDto;
import com.learn2code.vehicle.api.search.payload.VehicleDetailDto;
import com.learn2code.vehicle.api.search.payload.VehicleDetailPayLoad;

import java.util.List;

public interface VehicleDetailsService {

   List<ClientVehicleDetailsDto> getAllVehicleDetails();

   VehicleDetailDto getVehicleById(int vehicleId);

}
