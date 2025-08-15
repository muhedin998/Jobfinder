package com.jobfinder.jobfinder.models.dtos.request;

import com.jobfinder.jobfinder.models.enums.JobType;
import com.jobfinder.jobfinder.models.enums.ExperienceLevel;
import com.jobfinder.jobfinder.models.validation.ValidationGroups;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobRequestDTO {
    
    @NotBlank(message = "Job title is required")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;
    
    @NotBlank(message = "Job description is required")
    @Size(max = 5000, message = "Description must be less than 5000 characters")
    private String description;
    
    @Size(max = 3000, message = "Requirements must be less than 3000 characters")
    private String requirements;
    
    @NotBlank(message = "Location is required")
    @Size(max = 100, message = "Location must be less than 100 characters")
    private String location;
    
    @NotNull(message = "Job type is required")
    private JobType jobType;
    
    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @DecimalMax(value = "9999999.99", message = "Salary must be less than 10,000,000")
    private BigDecimal salary;
    
    @NotBlank(message = "Company name is required")
    @Size(max = 100, message = "Company name must be less than 100 characters")
    private String companyName;
    
    // Optional fields
    private ExperienceLevel experienceLevel;
    
    @Builder.Default
    private Boolean isRemote = false;
    
    private LocalDateTime applicationDeadline;
    
    // Simple ID references instead of full DTOs
    private Long categoryId;
    
    private Set<Long> skillIds;
    
    // Additional useful fields
    @Size(max = 500, message = "Benefits must be less than 500 characters")
    private String benefits;
    
    @Min(value = 1, message = "Minimum positions must be at least 1")
    @Max(value = 100, message = "Maximum positions cannot exceed 100")
    private Integer positions = 1;
    
    @Builder.Default
    private Boolean isDraft = false;
}