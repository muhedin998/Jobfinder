package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.JobCategoryDTO;
import com.jobfinder.jobfinder.models.entities.JobCategory;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOMapper {

    public JobCategoryDTO apply(JobCategory entity, Long id) {
        if (entity == null) return null;
        
        return JobCategoryDTO.builder()
                .categoryId(entity.getId())
                .categoryName(entity.getCategoryName())
                .build();
    }
}
