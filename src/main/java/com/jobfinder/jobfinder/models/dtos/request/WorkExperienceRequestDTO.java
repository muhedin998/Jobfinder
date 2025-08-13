package com.jobfinder.jobfinder.models.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkExperienceRequestDTO {
    
    @NotBlank(message = "Job title is required")
    @Size(max = 255, message = "Job title must be less than 255 characters")
    private String jobTitle;
    
    @NotBlank(message = "Company name is required")
    @Size(max = 255, message = "Company name must be less than 255 characters")
    private String companyName;
    
    @Size(max = 255, message = "Location must be less than 255 characters")
    private String location;
    
    @Size(max = 100, message = "Employment type must be less than 100 characters")
    private String employmentType;
    
    @NotNull(message = "Start date is required")
    @PastOrPresent(message = "Start date must be in the past or present")
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private Boolean currentlyWorking;
    
    @Size(max = 2000, message = "Description must be less than 2000 characters")
    private String description;
    
    @Size(max = 1000, message = "Achievements must be less than 1000 characters")
    private String achievements;
    
    @Min(value = 0, message = "Salary cannot be negative")
    private Float salary;
    
    @NotNull(message = "User profile ID is required")
    private Long userProfileId;
}