package com.jobfinder.jobfinder.models.dtos.request;

import com.jobfinder.jobfinder.models.enums.JobType;
import com.jobfinder.jobfinder.models.enums.ExperienceLevel;
import com.jobfinder.jobfinder.models.enums.Status;
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
public class UpdateJobRequestDTO {
    
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;
    
    @Size(max = 5000, message = "Description must be less than 5000 characters")
    private String description;
    
    @Size(max = 3000, message = "Requirements must be less than 3000 characters")
    private String requirements;
    
    @Size(max = 100, message = "Location must be less than 100 characters")
    private String location;
    
    private JobType jobType;
    
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    @DecimalMax(value = "9999999.99", message = "Salary must be less than 10,000,000")
    private BigDecimal salary;
    
    @Size(max = 100, message = "Company name must be less than 100 characters")
    private String companyName;
    
    private ExperienceLevel experienceLevel;
    private Boolean isRemote;
    private LocalDateTime applicationDeadline;
    private Long categoryId;
    private Set<Long> skillIds;
    private String benefits;
    
    @Min(value = 1, message = "Minimum positions must be at least 1")
    @Max(value = 100, message = "Maximum positions cannot exceed 100")
    private Integer positions;
    
    private Status status;
}