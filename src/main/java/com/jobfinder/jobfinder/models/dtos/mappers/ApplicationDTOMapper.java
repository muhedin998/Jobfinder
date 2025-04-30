package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.EntityMapper;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;

import java.util.stream.Collectors;

public enum ApplicationDTOMapper implements EntityMapper<JobApplicationResponseDTO, Applications, Long> {
    INSTANCE;

    @Override
    public JobApplicationResponseDTO apply(Applications entity, Long id) {
        JobApplicationResponseDTO jobApplicationResponseDTO = new JobApplicationResponseDTO();
        jobApplicationResponseDTO.setApplicationId(entity.getId());
        jobApplicationResponseDTO.setJob(JobDTOMapper.INSTANCE.apply(entity.getJob(), entity.getJob().getId()));
        jobApplicationResponseDTO.setUser(UserDTOMapper.INSTANCE.apply(entity.getUser(), entity.getUser().getId()));
        jobApplicationResponseDTO.setApplicationStatus(entity.getApplicationStatus());
        jobApplicationResponseDTO.setCoverLetter(entity.getCoverLetter());
        jobApplicationResponseDTO.setCvLink(entity.getCvLink());
        jobApplicationResponseDTO.setAppliedAt(entity.getDateApplied());
        return jobApplicationResponseDTO;
    }
}