package com.jobfinder.jobfinder.models.dtos.request;

import com.jobfinder.jobfinder.models.enums.Roles;
import lombok.Data;
import jakarta.validation.constraints.*;

import java.util.Set;

@Data
public class UserCreateRequestDTO {
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
    private Roles role;
    @NotBlank(message = "Full name is required")
    @Size(max = 255, message = "Full name must be less than 255 characters")
    private String fullName;
    private Set<Long> skillIds;
}
