package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.exceptions.InvalidDataException;
import com.jobfinder.jobfinder.models.dtos.request.JobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;
import com.jobfinder.jobfinder.models.enums.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class JobMapperComponent {

    @Autowired
    private JobCategoryMapper jobCategoryMapper;

    @Autowired
    private SkillMapperComponent skillMapper;

    @Autowired
    private UserMapperComponent userMapper;

    public Job toEntity(JobRequestDTO dto) {
        if (dto == null) return null;

        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setCompanyName(dto.getCompanyName());
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setJobType(dto.getJobType());
        job.setRequirements(dto.getRequirements());
        job.setDatePosted(LocalDateTime.now());
        job.setStatus(Status.ACTIVE);

        // Safe salary parsing
        if (dto.getSalary() != null && !dto.getSalary().trim().isEmpty()) {
            try {
                job.setSalary(Float.parseFloat(dto.getSalary()));
            } catch (NumberFormatException e) {
                throw new InvalidDataException("Invalid salary format: " + dto.getSalary());
            }
        }

        // Map relationships
        if (dto.getCategory() != null) {
            job.setJobCategory(jobCategoryMapper.toEntity(dto.getCategory()));
        }

        if (dto.getSkill() != null) {
            job.setSkills(dto.getSkill().stream()
                    .map(skillMapper::toEntity)
                    .collect(Collectors.toSet()));
        }

        if (dto.getUser() != null) {
            job.setUser(userMapper.toEntity(dto.getUser()));
        }

        return job;
    }

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
        dto.setStatus(entity.getStatus());

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