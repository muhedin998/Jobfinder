package com.jobfinder.jobfinder.models.dtos.response;

import com.jobfinder.jobfinder.models.enums.JobStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class JobResponseDTO {
    private Long jobId;
    private String title;
    private String description;
    private String requirements;
    private String location;
    private String jobType;
    private Float salary;
    private JobCategoryResponseDTO category;
    private Set<SkillResponseDTO> skills;
    private String companyName;
    private LocalDateTime postedAt;
    private JobStatus status;
}
