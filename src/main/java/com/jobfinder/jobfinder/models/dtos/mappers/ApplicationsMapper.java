package com.jobfinder.jobfinder.models.dtos.mappers;

import com.jobfinder.jobfinder.integration.DTOMapper;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;

public enum ApplicationsMapper implements DTOMapper<Applications, JobApplicationResponseDTO> {
    INSTANCE;

    @Override
    public Applications apply(JobApplicationResponseDTO responseDTO) {
        Applications applications = new Applications();
        applications.setId(responseDTO.getApplicationId());
        applications.setJob(JobMapper.INSTANCE.apply(responseDTO.getJob()));
        applications.setUser(UserMapper.INSTANCE.apply(responseDTO.getUser()));
        applications.setApplicationStatus(responseDTO.getApplicationStatus());
        applications.setDateApplied(responseDTO.getAppliedAt());
        applications.setCvLink(responseDTO.getCvLink());
        applications.setCoverLetter(responseDTO.getCoverLetter());

        return applications;
    }
}
