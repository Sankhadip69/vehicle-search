package com.learn2code.vehicle.api.search.controller;

import com.learn2code.vehicle.api.search.entity.Model;
import com.learn2code.vehicle.api.search.entity.TrimType;
import com.learn2code.vehicle.api.search.exception.ModelNotFoundException;
import com.learn2code.vehicle.api.search.payload.ModelDto;
import com.learn2code.vehicle.api.search.payload.TrimTypeDto;
import com.learn2code.vehicle.api.search.service.ModelTrimService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/model-trim")
@AllArgsConstructor
public class ModelTrimController {

    private ModelTrimService modelTrimService;

    @PostMapping
    public ResponseEntity<ModelDto> createModelTrim(@RequestBody ModelDto modelDto) {
        ModelDto savedModel = modelTrimService.saveModel(modelDto);
        return new ResponseEntity<>(savedModel, HttpStatus.CREATED);
    }

    @PostMapping("/trim-type")
    public ResponseEntity<TrimTypeDto> createTrimType(@RequestBody TrimTypeDto trimTypeDto) {
        TrimTypeDto saveTrimType = modelTrimService.saveTrimType(trimTypeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveTrimType);
    }

    @GetMapping
    public ResponseEntity<List<ModelDto>> fetchAllModels() {
        List<ModelDto> allModels = modelTrimService.getAllModels();
        if(allModels.size() > 0) {
            return new ResponseEntity<>(allModels, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDto> updateModel(@RequestBody ModelDto modelDto, @PathVariable int id) {
        ModelDto modifiedModelDto = modelTrimService.modifyModelDto(modelDto, id);
        return new ResponseEntity<>(modifiedModelDto, HttpStatus.OK);
    }

    @PutMapping("/trim-type/{id}")
    public ResponseEntity<TrimTypeDto> updateTrimType(@RequestBody TrimTypeDto trimTypeDto, @PathVariable int id) {
        TrimTypeDto modifiedTrimTypeDto = modelTrimService.modifyTrimTypeDto(trimTypeDto, id);
        return  ResponseEntity.ok(modifiedTrimTypeDto);
    }

   /* @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteModel(@PathVariable int id) {
        modelTrimService.deleteModelById(id);
        return new ResponseEntity<>("Model is deleted from DB for ID-"+id, HttpStatus.OK);
    }*/

    @GetMapping("/manufacturer/{manufacturerId}")
    public ResponseEntity<List<ModelDto>> findallModelsForManufacturer(@PathVariable int manufacturerId) {
        List<ModelDto> allModels = modelTrimService.getModelsByManufacturerId(manufacturerId);
        if(allModels.size() > 0 ) {
            return new ResponseEntity<>(allModels, HttpStatus.OK);
        }else {
            throw new ModelNotFoundException("No models found in DB for manufacturer with ID-"+manufacturerId);
        }
    }

    @GetMapping("/manufacturer/{manufacturerName}")
    public ResponseEntity<List<ModelDto>> findAllModelsForManufacturerName(@PathVariable String manufacturerName) {
        List<ModelDto> dbModelsList = modelTrimService.getModelsByManufacturerName(manufacturerName);
        if(dbModelsList.size() > 0 ) {
            return new ResponseEntity<>(dbModelsList, HttpStatus.OK);
        }else {
            throw new ModelNotFoundException("No models found in DB for manufacturer with name-"+manufacturerName);
        }
    }

}
