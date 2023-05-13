package com.learn2code.vehicle.api.search.controller;

import com.learn2code.vehicle.api.search.payload.ClientVehicleDetailsDto;
import com.learn2code.vehicle.api.search.payload.VehicleDetailDto;
import com.learn2code.vehicle.api.search.payload.VehicleDetailPayLoad;
import com.learn2code.vehicle.api.search.service.VehicleDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{vehicleId}")
    public ResponseEntity<VehicleDetailDto> fetchVehicleById(@PathVariable int vehicleId) {
        return ResponseEntity.ok(vehicleDetailsService.getVehicleById(vehicleId));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ClientVehicleDetailsDto>> searchVehicleByFilterCriteria(@RequestParam String modelYear,
                                                                                       @RequestParam String brandName,
                                                                                       @RequestParam String modelName,
                                                                                       @RequestParam String trimType,
                                                                                       @RequestParam double price) {
        List<ClientVehicleDetailsDto> filterdVehicles = vehicleDetailsService.fetchVehicleDetailsByCriteria(modelYear,brandName,modelName,trimType,price);
        return new ResponseEntity<>(filterdVehicles, HttpStatus.OK);
    }

}
