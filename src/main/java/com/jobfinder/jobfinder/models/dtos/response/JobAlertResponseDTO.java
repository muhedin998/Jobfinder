package com.jobfinder.jobfinder.models.dtos.response;

import com.jobfinder.jobfinder.models.dtos.JobCategoryDTO;
import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class JobAlertResponseDTO {
    
    private Long id;
    
    private Long userId;
    
    private String alertName;
    
    private String keywords;
    
    private String location;
    
    private Float minSalary;
    
    private Float maxSalary;
    
    private String jobType;
    
    private String experienceLevel;
    
    private Boolean remoteWork;
    
    private Set<JobCategoryDTO> categories;
    
    private Set<SkillDTO> skills;
    
    private Boolean isActive;
    
    private String frequency;
    
    private LocalDateTime lastSent;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}