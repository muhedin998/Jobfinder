package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.JobCategoryDTO;
import com.jobfinder.jobfinder.models.entities.JobCategory;
import org.springframework.stereotype.Component;

@Component
public class JobCategoryMapper {
    
    public JobCategory toEntity(JobCategoryDTO dto) {
        if (dto == null) return null;
        
        JobCategory entity = new JobCategory();
        entity.setId(dto.getCategoryId());
        entity.setCategoryName(dto.getCategoryName());
        return entity;
    }
    
    public JobCategoryDTO toDto(JobCategory entity) {
        if (entity == null) return null;
        
        JobCategoryDTO dto = new JobCategoryDTO();
        dto.setCategoryId(entity.getId());
        dto.setCategoryName(entity.getCategoryName());
        return dto;
    }
}