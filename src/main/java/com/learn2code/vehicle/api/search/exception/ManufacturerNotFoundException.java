package com.learn2code.vehicle.api.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ManufacturerNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private Integer fieldValue;

    public ManufacturerNotFoundException(String resourceName, String fieldName, Integer fieldValue){
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }


}
