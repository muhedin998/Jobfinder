package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class EducationResponseDTO {
    
    private Long id;
    
    private Long userProfileId;
    
    private String institution;
    
    private String degree;
    
    private String fieldOfStudy;
    
    private String grade;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private Boolean currentlyStudying;
    
    private String description;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}