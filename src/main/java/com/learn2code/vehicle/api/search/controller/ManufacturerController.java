package com.learn2code.vehicle.api.search.controller;

import com.learn2code.vehicle.api.search.entity.Manufacturer;
import com.learn2code.vehicle.api.search.exception.ManufacturerNotFoundException;
import com.learn2code.vehicle.api.search.exception.MissingFieldException;
import com.learn2code.vehicle.api.search.payload.ManufacturerDto;
import com.learn2code.vehicle.api.search.service.ManufacturerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
    @PutMapping("/{id}")
    public ResponseEntity<ManufacturerDto> updateManufacturer(@PathVariable int id, @Valid 
                                                @RequestBody ManufacturerDto manufacturerDto){
        ManufacturerDto updateManufacturer = manufacturerService.updateManufacturer(manufacturerDto, id);
        return new ResponseEntity<>(updateManufacturer,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteManufacturer(@PathVariable int id) {
        manufacturerService.deleteManufacturerById(id);
        return new ResponseEntity<>("Manufacturer deleted from DB with ID- "+id, HttpStatus.OK);
    }


}
