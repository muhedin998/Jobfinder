package com.jobfinder.jobfinder.exceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
    
    public ForbiddenException() {
        super("Access forbidden. Insufficient permissions.");
    }
}