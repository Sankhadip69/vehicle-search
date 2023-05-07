package com.learn2code.vehicle.api.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ManufacturerNotFoundException extends RuntimeException{

    private String message;

    public ManufacturerNotFoundException(String message) {
        super(message);
    }

}
