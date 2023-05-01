package com.learn2code.vehicle.api.search.exception;

public class MissingFieldException extends RuntimeException {

    private String message;

    public MissingFieldException(String message) {
        super(message);
    }
}
