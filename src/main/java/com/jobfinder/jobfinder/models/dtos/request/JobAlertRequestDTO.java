package com.jobfinder.jobfinder.models.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Set;

@Data
public class JobAlertRequestDTO {
    
    @NotBlank(message = "Alert name is required")
    @Size(max = 255, message = "Alert name must be less than 255 characters")
    private String alertName;
    
    @Size(max = 500, message = "Keywords must be less than 500 characters")
    private String keywords;
    
    @Size(max = 255, message = "Location must be less than 255 characters")
    private String location;
    
    @Min(value = 0, message = "Minimum salary cannot be negative")
    private Float minSalary;
    
    @Min(value = 0, message = "Maximum salary cannot be negative")
    private Float maxSalary;
    
    @Size(max = 100, message = "Job type must be less than 100 characters")
    private String jobType;
    
    @Size(max = 100, message = "Experience level must be less than 100 characters")
    private String experienceLevel;
    
    private Boolean remoteWork;
    
    private Set<Long> categoryIds;
    
    private Set<Long> skillIds;
    
    @NotBlank(message = "Frequency is required")
    @Pattern(regexp = "^(DAILY|WEEKLY|MONTHLY)$", message = "Frequency must be DAILY, WEEKLY, or MONTHLY")
    private String frequency;
    
    @NotNull(message = "User ID is required")
    private Long userId;
}