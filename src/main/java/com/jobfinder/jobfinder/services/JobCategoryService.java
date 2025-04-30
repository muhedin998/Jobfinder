package com.jobfinder.jobfinder.services;

import com.jobfinder.jobfinder.models.entities.JobCategory;

public interface JobCategoryService {
    JobCategory getJobCategoryById(Long categoryId);
}
