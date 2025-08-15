package com.jobfinder.jobfinder.exceptions;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
    
    public UnauthorizedException() {
        super("Access denied. Please authenticate.");
    }
}