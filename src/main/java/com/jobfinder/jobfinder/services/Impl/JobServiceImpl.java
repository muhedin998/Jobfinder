package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.models.dtos.mappers.JobDTOMapper;
import com.jobfinder.jobfinder.models.dtos.mappers.JobMapper;
import com.jobfinder.jobfinder.models.dtos.request.JobApplicationRequestDTO;
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

    @Override
    public JobResponseDTO createJob(JobRequestDTO job) {
        Job newJob = jobRepository.save(Job.toEntity(job));
        return JobDTOMapper.INSTANCE.apply(newJob, newJob.getId());
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).get();
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.delete(jobRepository.findById(id).get());
    }
}
