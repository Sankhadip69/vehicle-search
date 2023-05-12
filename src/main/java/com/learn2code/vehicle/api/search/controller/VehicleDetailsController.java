package com.learn2code.vehicle.api.search.controller;

import com.learn2code.vehicle.api.search.payload.ClientVehicleDetailsDto;
import com.learn2code.vehicle.api.search.payload.VehicleDetailPayLoad;
import com.learn2code.vehicle.api.search.service.VehicleDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle-details")
@AllArgsConstructor
public class VehicleDetailsController {

    private VehicleDetailsService vehicleDetailsService;

    @GetMapping
    public ResponseEntity<List<ClientVehicleDetailsDto>> getAllVehicleDetails() {
        List<ClientVehicleDetailsDto> allVehicleDetails = vehicleDetailsService.getAllVehicleDetails();

        return new ResponseEntity<>(allVehicleDetails, HttpStatus.OK);
    }
}
