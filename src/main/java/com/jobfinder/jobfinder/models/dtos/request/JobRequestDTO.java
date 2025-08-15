package com.jobfinder.jobfinder.models.dtos.request;

import com.jobfinder.jobfinder.models.dtos.JobCategoryDTO;
import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import com.jobfinder.jobfinder.models.validation.ValidationGroups;
import lombok.Data;
import jakarta.validation.constraints.*;

import java.util.Set;

@Data
public class JobRequestDTO {
    @NotBlank(message = "Title is required", groups = {ValidationGroups.Create.class, ValidationGroups.JobPosting.class})
    @Size(max = 255, message = "Title must be less than 255 characters", groups = {ValidationGroups.Create.class, ValidationGroups.JobPosting.class})
    private String title;
    
    @NotBlank(message = "Description is required", groups = {ValidationGroups.Create.class, ValidationGroups.JobPosting.class})
    @Size(max = 5000, message = "Description must be less than 5000 characters", groups = {ValidationGroups.Create.class, ValidationGroups.JobPosting.class})
    private String description;
    
    private String requirements;
    
    @NotBlank(message = "Location is required", groups = {ValidationGroups.Create.class, ValidationGroups.JobPosting.class})
    private String location;
    
    private String jobType;
    
    @NotBlank(message = "Salary is required", groups = {ValidationGroups.Create.class, ValidationGroups.JobPosting.class})
    private String salary;
    
    private UserResponseDTO user;
    private JobCategoryDTO category;
    private Set<SkillDTO> skill;
    
    @NotBlank(message = "Company name is required", groups = {ValidationGroups.Create.class, ValidationGroups.JobPosting.class})
    private String companyName;
}
