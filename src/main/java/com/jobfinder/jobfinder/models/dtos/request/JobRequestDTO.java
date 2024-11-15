package com.jobfinder.jobfinder.models.dtos.request;

import com.jobfinder.jobfinder.models.dtos.JobCategoryDTO;
import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import com.jobfinder.jobfinder.models.dtos.response.UserResponseDTO;
import lombok.Data;

import java.util.Set;

@Data
public class JobRequestDTO {
    private String title;
    private String description;
    private String requirements;
    private String location;
    private String jobType;
    private String salary;
    private UserResponseDTO user;
    private JobCategoryDTO category;
    private Set<SkillDTO> skill;
    private String companyName;
}
