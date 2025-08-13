package com.jobfinder.jobfinder.models.dtos.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ResumeRequestDTO {
    
    @NotBlank(message = "File name is required")
    @Size(max = 255, message = "File name must be less than 255 characters")
    private String fileName;
    
    @NotBlank(message = "File URL is required")
    @Size(max = 500, message = "File URL must be less than 500 characters")
    private String fileUrl;
    
    @NotBlank(message = "File type is required")
    @Pattern(regexp = "^(PDF|DOC|DOCX)$", message = "File type must be PDF, DOC, or DOCX")
    private String fileType;
    
    @NotNull(message = "File size is required")
    @Min(value = 1, message = "File size must be greater than 0")
    @Max(value = 10485760, message = "File size must be less than 10MB") // 10MB in bytes
    private Long fileSize;
    
    private Boolean isDefault;
    
    private Boolean isPublic;
    
    @Size(max = 1000, message = "Description must be less than 1000 characters")
    private String description;
    
    @NotNull(message = "User profile ID is required")
    private Long userProfileId;
}