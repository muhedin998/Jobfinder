package com.jobfinder.jobfinder.models.dtos.request;

import com.jobfinder.jobfinder.models.validation.ValidationGroups;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterDTO {
    @NotBlank(message = "Full name is required", groups = ValidationGroups.Registration.class)
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters", groups = ValidationGroups.Registration.class)
    private String fullName;

    @NotBlank(message = "Username is required", groups = {ValidationGroups.Registration.class, ValidationGroups.Login.class})
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters", groups = ValidationGroups.Registration.class)
    private String username;

    @NotBlank(message = "Email is required", groups = ValidationGroups.Registration.class)
    @Email(message = "Please provide a valid email address", groups = ValidationGroups.Registration.class)
    private String email;

    @NotBlank(message = "Password is required", groups = {ValidationGroups.Registration.class, ValidationGroups.Login.class})
    @Size(min = 6, message = "Password must be at least 6 characters long", groups = ValidationGroups.Registration.class)
    private String password;
}
