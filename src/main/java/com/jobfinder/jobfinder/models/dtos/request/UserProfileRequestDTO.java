package com.jobfinder.jobfinder.models.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserProfileRequestDTO {
    
    @Size(max = 2000, message = "Bio must be less than 2000 characters")
    private String bio;
    
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Phone number must be valid")
    private String phone;
    
    @Size(max = 255, message = "Address must be less than 255 characters")
    private String address;
    
    @Size(max = 100, message = "City must be less than 100 characters")
    private String city;
    
    @Size(max = 100, message = "Country must be less than 100 characters")
    private String country;
    
    @Size(max = 255, message = "Website URL must be less than 255 characters")
    @Pattern(regexp = "^(https?://)?(www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(/.*)?$", 
             message = "Website must be a valid URL")
    private String website;
    
    @Size(max = 255, message = "LinkedIn URL must be less than 255 characters")
    private String linkedinUrl;
    
    @Size(max = 255, message = "GitHub URL must be less than 255 characters")
    private String githubUrl;
    
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;
    
    @Size(max = 255, message = "Profile image URL must be less than 255 characters")
    private String profileImageUrl;
    
    @Size(max = 1000, message = "Summary must be less than 1000 characters")
    private String summary;
    
    @Min(value = 0, message = "Years of experience cannot be negative")
    @Max(value = 100, message = "Years of experience cannot exceed 100")
    private Integer yearsOfExperience;
    
    @Min(value = 0, message = "Expected salary cannot be negative")
    private Float expectedSalary;
    
    @Size(max = 255, message = "Current job title must be less than 255 characters")
    private String currentJobTitle;
    
    private Boolean availableForWork;
}