package com.jobfinder.jobfinder.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "password123";
        String hash = encoder.encode(password);
        
        System.out.println("Password: " + password);
        System.out.println("BCrypt Hash: " + hash);
        
        // Verify the hash works
        boolean matches = encoder.matches(password, hash);
        System.out.println("Hash verification: " + matches);
        
        // Test with the current hash in database
        String currentHash = "$2a$10$N9qo8uLOickgx2ZMRZoMye/1X1F1QkqW1X9/qEwvYjqRzzU5dFWyW";
        boolean currentMatches = encoder.matches(password, currentHash);
        System.out.println("Current hash verification: " + currentMatches);
    }
}