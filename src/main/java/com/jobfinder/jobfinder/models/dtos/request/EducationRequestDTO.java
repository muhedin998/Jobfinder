package com.jobfinder.jobfinder.models.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationRequestDTO {
    
    @NotBlank(message = "Institution name is required")
    @Size(max = 255, message = "Institution name must be less than 255 characters")
    private String institution;
    
    @NotBlank(message = "Degree is required")
    @Size(max = 255, message = "Degree must be less than 255 characters")
    private String degree;
    
    @Size(max = 255, message = "Field of study must be less than 255 characters")
    private String fieldOfStudy;
    
    @Size(max = 50, message = "Grade must be less than 50 characters")
    private String grade;
    
    @NotNull(message = "Start date is required")
    @PastOrPresent(message = "Start date must be in the past or present")
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private Boolean currentlyStudying;
    
    @Size(max = 1000, message = "Description must be less than 1000 characters")
    private String description;
    
    @NotNull(message = "User profile ID is required")
    private Long userProfileId;
}