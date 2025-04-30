package com.jobfinder.jobfinder.models.mappers;

import com.jobfinder.jobfinder.integration.DTOMapper;
import com.jobfinder.jobfinder.integration.EntityMapper;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;

public class JobMapper implements DTOMapper<Job, JobResponseDTO> {

    @Override
    public <D> D apply(JobResponseDTO dto) {
        Job job = new Job();
        job.setDescription(dto.getDescription());
        job.setLocation(dto.getLocation());
        job.setCompanyName(dto.getCompanyName());
        job.setSalary(dto.getSalary());
        job.setJobType(dto.getJobType());
        job.setDatePosted(dto.getPostedAt());
        return null;
    }
}
