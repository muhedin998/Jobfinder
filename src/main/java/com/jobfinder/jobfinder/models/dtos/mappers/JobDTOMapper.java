package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.EntityMapper;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;

import java.util.stream.Collectors;

public enum JobDTOMapper implements EntityMapper<JobResponseDTO, Job, Long> {
    INSTANCE;

    @Override
    public JobResponseDTO apply(Job entity, Long id) {
        JobResponseDTO jobResponseDTO = new JobResponseDTO();
        jobResponseDTO.setJobId(entity.getId());
        jobResponseDTO.setTitle(entity.getTitle());
        jobResponseDTO.setDescription(entity.getDescription());
        jobResponseDTO.setLocation(entity.getLocation());
        jobResponseDTO.setCategory(CategoryDTOMapper.INSTANCE
                .apply(entity.getJobCategory(), entity.getJobCategory().getId()));
        jobResponseDTO.setRequirements(entity.getRequirements());
        jobResponseDTO.setSalary(entity.getSalary());
        jobResponseDTO.setJobType(entity.getJobType());
        jobResponseDTO.setCompanyName(entity.getCompanyName());
        jobResponseDTO.setPostedAt(entity.getDatePosted());
        jobResponseDTO.setSkills(entity.getSkills().stream().map(skill ->
                SkillDTOMapper.INSTANCE.apply(skill, skill.getId()))
                .collect(Collectors.toSet()));
        return jobResponseDTO;
    }
}
