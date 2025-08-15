package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class JobDTOMapper {

    @Autowired
    private CategoryDTOMapper categoryDTOMapper;

    @Autowired
    private SkillDTOMapper skillDTOMapper;

    public JobResponseDTO apply(Job entity, Long id) {
        if (entity == null) return null;
        
        return JobResponseDTO.builder()
                .jobId(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .location(entity.getLocation())
                .category(entity.getJobCategory() != null ? 
                    categoryDTOMapper.apply(entity.getJobCategory(), entity.getJobCategory().getId()) : null)
                .requirements(entity.getRequirements())
                .salary(entity.getSalary())
                .jobType(entity.getJobType())
                .companyName(entity.getCompanyName())
                .postedAt(entity.getDatePosted())
                .status(entity.getStatus())
                .skills(entity.getSkills() != null ? 
                    entity.getSkills().stream()
                        .map(skill -> skillDTOMapper.apply(skill, skill.getId()))
                        .collect(Collectors.toSet()) : null)
                .build();
    }
}
