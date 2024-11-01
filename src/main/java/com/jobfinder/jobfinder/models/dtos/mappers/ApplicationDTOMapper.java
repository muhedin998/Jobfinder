package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.EntityMapper;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;

public enum ApplicationDTOMapper implements EntityMapper<JobApplicationResponseDTO, Applications> {
    INSTANCE;

    @Override
    public JobApplicationResponseDTO apply(Applications entity, Long id) {
        return null;
    }
}
