package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.models.AppUser;
import com.jobfinder.jobfinder.models.AuthenticationRequest;
import com.jobfinder.jobfinder.models.AuthenticationResponse;
import com.jobfinder.jobfinder.models.RegisterRequest;
import com.jobfinder.jobfinder.models.enums.Roles;
import com.jobfinder.jobfinder.repositories.AppUserRepository;
import com.jobfinder.jobfinder.services.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl {
    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;

    private final JwtServiceImpl jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = AppUser.builder()
                .fullName(request.getFullName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Roles.USER)
                .build();

                appUserService.createUser(user);
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = appUserService.findByUsername(request.getUsername());
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
