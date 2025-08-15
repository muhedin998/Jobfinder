package com.jobfinder.jobfinder.models.dtos.response;

import com.jobfinder.jobfinder.models.dtos.JobCategoryDTO;
import com.jobfinder.jobfinder.models.dtos.SkillDTO;
import com.jobfinder.jobfinder.models.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobResponseDTO {
    private Long jobId;
    private String title;
    private String description;
    private String requirements;
    private String location;
    private String jobType;
    private Float salary;
    private JobCategoryDTO category;
    private Set<SkillDTO> skills;
    private String companyName;
    private LocalDateTime postedAt;
    private Status status;
}