package com.jobfinder.jobfinder.services;

import com.jobfinder.jobfinder.models.dtos.request.CreateJobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.request.UpdateJobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.Job;
import com.jobfinder.jobfinder.models.enums.JobType;
import com.jobfinder.jobfinder.models.enums.ExperienceLevel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobService {
    JobResponseDTO createJob(CreateJobRequestDTO request);
    JobResponseDTO updateJob(Long jobId, UpdateJobRequestDTO request);
    List<Job> getAllJobs();
    List<Job> searchJobs(String title, String location, JobType jobType, ExperienceLevel experienceLevel, Boolean isRemote);
    List<Job> getJobsByCurrentUser();
    Job getJobById(Long id);
    void deleteJob(Long id);
}
