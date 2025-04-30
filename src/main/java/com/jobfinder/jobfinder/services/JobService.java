package com.jobfinder.jobfinder.services;

import com.jobfinder.jobfinder.models.dtos.request.JobApplicationRequestDTO;
import com.jobfinder.jobfinder.models.dtos.request.JobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;

import java.util.List;

public interface JobService {
    JobResponseDTO createJob(JobRequestDTO job);

    List<Job> getAllJobs();

    Job getJobById(Long id);

    void deleteJob(Long id);
}
