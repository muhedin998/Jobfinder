package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.exceptions.InvalidDataException;
import com.jobfinder.jobfinder.exceptions.ResourceNotFoundException;
import com.jobfinder.jobfinder.models.dtos.mappers.JobDTOMapper;
import com.jobfinder.jobfinder.models.dtos.mappers.JobMapperComponent;
import com.jobfinder.jobfinder.models.dtos.request.JobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;
import com.jobfinder.jobfinder.repositories.JobRepository;
import com.jobfinder.jobfinder.services.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private JobMapperComponent jobMapper;
    
    @Autowired
    private JobDTOMapper jobDTOMapper;

    @Override
    public JobResponseDTO createJob(JobRequestDTO job) {
        if (job == null) {
            throw new InvalidDataException("Job request cannot be null");
        }
        if (job.getTitle() == null || job.getTitle().trim().isEmpty()) {
            throw new InvalidDataException("Job title cannot be empty");
        }
        if (job.getDescription() == null || job.getDescription().trim().isEmpty()) {
            throw new InvalidDataException("Job description cannot be empty");
        }
        
        try {
            Job newJob = jobRepository.save(jobMapper.toEntity(job));
            return jobDTOMapper.apply(newJob, newJob.getId());
        } catch (Exception e) {
            throw new InvalidDataException("Failed to create job: " + e.getMessage());
        }
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidDataException("Job ID must be a positive number");
        }
        
        return jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", id));
    }

    @Override
    public void deleteJob(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidDataException("Job ID must be a positive number");
        }
        
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", id));
        
        try {
            jobRepository.delete(job);
        } catch (Exception e) {
            throw new InvalidDataException("Failed to delete job: " + e.getMessage());
        }
    }
}
