package com.jobfinder.jobfinder.models.dtos.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserProfileResponseDTO {
    
    private Long id;
    
    private Long userId;
    
    private String bio;
    
    private String phone;
    
    private String address;
    
    private String city;
    
    private String country;
    
    private String website;
    
    private String linkedinUrl;
    
    private String githubUrl;
    
    private LocalDate dateOfBirth;
    
    private String profileImageUrl;
    
    private String summary;
    
    private Integer yearsOfExperience;
    
    private Float expectedSalary;
    
    private String currentJobTitle;
    
    private Boolean availableForWork;
    
    private List<EducationResponseDTO> educations;
    
    private List<WorkExperienceResponseDTO> workExperiences;
    
    private List<ResumeResponseDTO> resumes;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
}