package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDTOMapper {

    @Autowired
    private JobDTOMapper jobDTOMapper;
    
    @Autowired
    private UserDTOMapper userDTOMapper;

    public JobApplicationResponseDTO apply(Applications entity, Long id) {
        if (entity == null) return null;
        
        JobApplicationResponseDTO dto = new JobApplicationResponseDTO();
        dto.setApplicationId(entity.getId());
        
        if (entity.getJob() != null) {
            dto.setJob(jobDTOMapper.apply(entity.getJob(), entity.getJob().getId()));
        }
        
        if (entity.getUser() != null) {
            dto.setUser(userDTOMapper.apply(entity.getUser(), entity.getUser().getId()));
        }
        
        dto.setCoverLetter(entity.getCoverLetter());
        dto.setCvLink(entity.getCvLink());
        dto.setAppliedAt(entity.getDateApplied());
        
        return dto;
    }
}