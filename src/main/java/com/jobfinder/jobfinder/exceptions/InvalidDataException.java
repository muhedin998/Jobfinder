package com.jobfinder.jobfinder.exceptions;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
    
    public InvalidDataException(String field, String value) {
        super(String.format("Invalid %s: %s", field, value));
    }
}