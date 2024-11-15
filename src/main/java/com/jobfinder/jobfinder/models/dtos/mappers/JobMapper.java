package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.DTOMapper;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;
import com.jobfinder.jobfinder.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public enum JobMapper implements DTOMapper<Job, JobResponseDTO> {
    INSTANCE;

    @Autowired
    private JobService jobService;

    @Override
    public Job apply(JobResponseDTO dto) {
        Job job = jobService.getJobById(dto.getJobId());

        job.setId(dto.getJobId());
        job.setTitle(dto.getTitle());
        job.setDescription(dto.getDescription());
        job.setRequirmnets(dto.getRequirements());
        job.setLocation(dto.getLocation());
        job.setJobType(dto.getJobType());
        job.setJobCategory(JobCatergoryMapper.INSTANCE.apply(dto.getCategory()));
        job.setSalary(dto.getSalary());
        job.setSkills(dto.getSkills().stream().map(SkillMapper.INSTANCE::apply).collect(Collectors.toSet()));
        job.setCompanyName(dto.getCompanyName());
        job.setDatePosted(dto.getPostedAt());

        return job;
    }
}
