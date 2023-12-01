package com.jobfinder.jobfinder.services;

import com.jobfinder.jobfinder.models.Job;

import java.util.List;

public interface JobService {
    Job createJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(Long id);

    void deleteJob(Long id);
}
