package com.jobfinder.jobfinder.models.mappers;

import com.jobfinder.jobfinder.integration.DTOMapper;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;
import org.springframework.stereotype.Component;

@Component
public class JobMapper implements DTOMapper<Job, JobResponseDTO> {

    @Override
    public Job apply(JobResponseDTO dto) {
        if (dto == null) return null;
        
        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setCompanyName(dto.getCompanyName());
        job.setSalary(dto.getSalary());
        job.setJobType(dto.getJobType());
        job.setDatePosted(dto.getPostedAt());
        job.setRequirements(dto.getRequirements());
        job.setStatus(dto.getStatus());
        return job;
    }
}
