package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.models.AppUser;
import com.jobfinder.jobfinder.models.Job;
import com.jobfinder.jobfinder.repositories.AppUserRepository;
import com.jobfinder.jobfinder.repositories.JobRepository;
import com.jobfinder.jobfinder.services.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
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
