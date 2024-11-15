package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.EntityMapper;
import com.jobfinder.jobfinder.models.dtos.JobCategoryDTO;
import com.jobfinder.jobfinder.models.entities.JobCategory;

public enum CategoryDTOMapper implements EntityMapper<JobCategoryDTO, JobCategory, Long> {
    INSTANCE;

    @Override
    public JobCategoryDTO apply(JobCategory entity, Long id) {
        JobCategoryDTO jobCategoryDTO = new JobCategoryDTO();
        jobCategoryDTO.setCategoryId(entity.getCategoryId());
        jobCategoryDTO.setCategoryName(entity.getCategoryName());

        return jobCategoryDTO;
    }
}
