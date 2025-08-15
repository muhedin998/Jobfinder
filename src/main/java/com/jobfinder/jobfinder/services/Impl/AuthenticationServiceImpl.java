package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.exceptions.InvalidDataException;
import com.jobfinder.jobfinder.exceptions.UserAlreadyExistsException;
import com.jobfinder.jobfinder.models.entities.AppUser;
import com.jobfinder.jobfinder.models.dtos.request.AuthenticationRequest;
import com.jobfinder.jobfinder.models.dtos.response.AuthenticationResponse;
import com.jobfinder.jobfinder.models.dtos.request.UserRegisterDTO;
import com.jobfinder.jobfinder.models.enums.Roles;
import com.jobfinder.jobfinder.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;

    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(UserRegisterDTO request) {
        if (request == null) {
            throw new InvalidDataException("Registration request cannot be null");
        }
        
        validateRegistrationData(request);
        
        var user = AppUser.builder()
                .fullName(request.getFullName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.USER)
                .build();
                
        var existingUser = appUserService.findOptionalUser(user.getUsername());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("username", user.getUsername());
        }
        
        try {
            appUserService.createUser(user);
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .user(user)
                    .token(jwtToken)
                    .build();
        } catch (Exception e) {
            throw new InvalidDataException("Failed to register user: " + e.getMessage());
        }
    }
    
    private void validateRegistrationData(UserRegisterDTO request) {
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new InvalidDataException("Username cannot be empty");
        }
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            throw new InvalidDataException("Email cannot be empty");
        }
        if (request.getPassword() == null || request.getPassword().length() < 6) {
            throw new InvalidDataException("Password must be at least 6 characters long");
        }
        if (request.getFullName() == null || request.getFullName().trim().isEmpty()) {
            throw new InvalidDataException("Full name cannot be empty");
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        if (request == null) {
            throw new InvalidDataException("Authentication request cannot be null");
        }
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new InvalidDataException("Username cannot be empty");
        }
        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            throw new InvalidDataException("Password cannot be empty");
        }
        
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
            
            var user = appUserService.findByUsername(request.getUsername());
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .user(user)
                    .token(jwtToken)
                    .build();
        } catch (Exception e) {
            throw new InvalidDataException("Authentication failed: Invalid credentials");
        }
    }
}
