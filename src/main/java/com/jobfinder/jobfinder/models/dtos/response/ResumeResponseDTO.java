package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResumeResponseDTO {
    
    private Long id;
    
    private Long userProfileId;
    
    private String fileName;
    
    private String fileUrl;
    
    private String fileType;
    
    private Long fileSize;
    
    private Boolean isDefault;
    
    private Boolean isPublic;
    
    private String description;
    
    private LocalDateTime uploadedAt;
    
    private LocalDateTime updatedAt;
}