package com.learn2code.vehicle.api.search.controller;

import com.learn2code.vehicle.api.search.entity.Manufacturer;
import com.learn2code.vehicle.api.search.payload.ManufacturerDto;
import com.learn2code.vehicle.api.search.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
