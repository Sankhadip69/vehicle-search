package com.learn2code.vehicle.api.search.controller;

import com.learn2code.vehicle.api.search.entity.Manufacturer;
import com.learn2code.vehicle.api.search.exception.ManufacturerNotFoundException;
import com.learn2code.vehicle.api.search.payload.ManufacturerDto;
import com.learn2code.vehicle.api.search.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/manufacturers")
@AllArgsConstructor
public class ManufacturerController {

    private ManufacturerService manufacturerService;

    @PostMapping
    public ResponseEntity<ManufacturerDto> createManufacturerInDb(@RequestBody
                                                                ManufacturerDto manufacturerDto) {
        ManufacturerDto saveManufacturer = manufacturerService.saveManufacturer(manufacturerDto);
        return new ResponseEntity<>(saveManufacturer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ManufacturerDto>> getAllManufacturers() {
        List<ManufacturerDto> savedManufacturers = manufacturerService.fetchAllManufacturers();
        return ResponseEntity.status(HttpStatus.OK).body(savedManufacturers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManufacturerDto> getManufacturerBasedOnId(@PathVariable("id") int id) {
        return ResponseEntity.ok(manufacturerService.getManufacturerForId(id));
    }

}
