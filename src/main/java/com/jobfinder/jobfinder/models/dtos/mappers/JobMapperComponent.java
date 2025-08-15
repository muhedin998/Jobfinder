package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class JobMapperComponent {

    @Autowired
    private JobCategoryMapper jobCategoryMapper;

    @Autowired
    private SkillMapperComponent skillMapper;

    public JobResponseDTO toResponseDto(Job entity) {
        if (entity == null) return null;

        JobResponseDTO dto = new JobResponseDTO();
        dto.setJobId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setLocation(entity.getLocation());
        dto.setJobType(entity.getJobType());
        dto.setRequirements(entity.getRequirements());
        dto.setSalary(entity.getSalary());
        dto.setCompanyName(entity.getCompanyName());
        dto.setPostedAt(entity.getDatePosted());
        dto.setApplicationDeadline(entity.getApplicationDeadline());
        dto.setStatus(entity.getStatus());
        dto.setExperienceLevel(entity.getExperienceLevel());
        dto.setIsRemote(entity.getIsRemote());
        dto.setBenefits(entity.getBenefits());
        dto.setPositions(entity.getPositions());
        dto.setIsDraft(entity.getIsDraft());

        // Map relationships
        if (entity.getJobCategory() != null) {
            dto.setCategory(jobCategoryMapper.toDto(entity.getJobCategory()));
        }

        if (entity.getSkills() != null) {
            dto.setSkills(entity.getSkills().stream()
                    .map(skillMapper::toDto)
                    .collect(Collectors.toSet()));
        }

        return dto;
    }
}