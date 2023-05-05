package com.learn2code.vehicle.api.search.controller;

import com.learn2code.vehicle.api.search.entity.Model;
import com.learn2code.vehicle.api.search.entity.TrimType;
import com.learn2code.vehicle.api.search.payload.ModelDto;
import com.learn2code.vehicle.api.search.payload.TrimTypeDto;
import com.learn2code.vehicle.api.search.service.ModelTrimService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
