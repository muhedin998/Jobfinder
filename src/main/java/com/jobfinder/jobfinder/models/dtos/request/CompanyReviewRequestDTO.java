package com.jobfinder.jobfinder.models.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CompanyReviewRequestDTO {
    
    @NotNull(message = "Company ID is required")
    private Long companyId;
    
    @NotNull(message = "Overall rating is required")
    @Min(value = 1, message = "Overall rating must be between 1 and 5")
    @Max(value = 5, message = "Overall rating must be between 1 and 5")
    private Integer overallRating;
    
    @Min(value = 1, message = "Work-life balance rating must be between 1 and 5")
    @Max(value = 5, message = "Work-life balance rating must be between 1 and 5")
    private Integer workLifeBalanceRating;
    
    @Min(value = 1, message = "Salary rating must be between 1 and 5")
    @Max(value = 5, message = "Salary rating must be between 1 and 5")
    private Integer salaryRating;
    
    @Min(value = 1, message = "Culture rating must be between 1 and 5")
    @Max(value = 5, message = "Culture rating must be between 1 and 5")
    private Integer cultureRating;
    
    @Min(value = 1, message = "Management rating must be between 1 and 5")
    @Max(value = 5, message = "Management rating must be between 1 and 5")
    private Integer managementRating;
    
    @Size(max = 255, message = "Job title must be less than 255 characters")
    private String jobTitle;
    
    @Size(max = 100, message = "Employment status must be less than 100 characters")
    private String employmentStatus;
    
    @Size(max = 2000, message = "Pros must be less than 2000 characters")
    private String pros;
    
    @Size(max = 2000, message = "Cons must be less than 2000 characters")
    private String cons;
    
    @Size(max = 1000, message = "Advice must be less than 1000 characters")
    private String advice;
    
    private Boolean recommendToFriend;
    
    private Boolean approveOfCeo;
    
    private Boolean isAnonymous;
    
    @NotNull(message = "User ID is required")
    private Long userId;
}