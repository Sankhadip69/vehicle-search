package com.learn2code.vehicle.api.search.exception;

public class ModelNotFoundException extends RuntimeException{

    private String message;

    public ModelNotFoundException(String message) {
        super(message);
    }
}
