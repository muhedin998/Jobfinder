package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.models.entities.JobCategory;
import com.jobfinder.jobfinder.repositories.JobCategoryRepository;
import com.jobfinder.jobfinder.services.JobCategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JobCategoryServiceImpl implements JobCategoryService {

    @Autowired
    JobCategoryRepository jobCategoryRepository;
    @Override
    public JobCategory getJobCategoryById(Long categoryId) {
        return jobCategoryRepository.getReferenceById(categoryId);
    }
}
