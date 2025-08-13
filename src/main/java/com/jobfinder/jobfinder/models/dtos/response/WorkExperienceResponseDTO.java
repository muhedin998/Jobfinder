package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WorkExperienceResponseDTO {
    
    private Long id;
    
    private Long userProfileId;
    
    private String jobTitle;
    
    private String companyName;
    
    private String location;
    
    private String employmentType;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private Boolean currentlyWorking;
    
    private String description;
    
    private String achievements;
    
    private Float salary;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}