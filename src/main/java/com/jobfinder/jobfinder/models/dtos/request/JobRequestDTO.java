package com.jobfinder.jobfinder.models.dtos.request;

import com.jobfinder.jobfinder.models.dtos.JobCategoryDTO;
import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import lombok.Data;
import jakarta.validation.constraints.*;

import java.util.Set;

@Data
public class JobRequestDTO {
    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;
    @NotBlank(message = "Description is required")
    @Size(max = 5000, message = "Description must be less than 5000 characters")
    private String description;
    private String requirements;
    @NotBlank(message = "Location is required")
    private String location;
    private String jobType;
    @NotBlank(message = "Salary is required")
    private String salary;
    private UserResponseDTO user;
    private JobCategoryDTO category;
    private Set<SkillDTO> skill;
    @NotBlank(message = "Company name is required")
    private String companyName;
}
