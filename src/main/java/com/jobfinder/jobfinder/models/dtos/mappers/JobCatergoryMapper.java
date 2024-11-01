package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.DTOMapper;
import com.jobfinder.jobfinder.models.dtos.JobCategoryDTO;
import com.jobfinder.jobfinder.models.entities.JobCategory;
import com.jobfinder.jobfinder.services.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public enum JobCatergoryMapper implements DTOMapper<JobCategory, JobCategoryDTO> {
    INSTANCE;

    @Autowired
    JobCategoryService jobCategoryService;

    @Override
    public JobCategory apply(JobCategoryDTO dto) {
        JobCategory jobCategory = jobCategoryService.getJobCategoryById(dto.getCategoryId());
        jobCategory.setCategoryName(dto.getCategoryName());
        return jobCategory;
    }
}
