package com.learn2code.vehicle.api.search.exception;

public class TrimTypeNotFoundException extends RuntimeException{

    private String message;

    public TrimTypeNotFoundException(String message) {
        super(message);
    }
}
