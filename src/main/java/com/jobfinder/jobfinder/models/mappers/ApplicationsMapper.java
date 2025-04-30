package com.jobfinder.jobfinder.models.mappers;

import com.jobfinder.jobfinder.integration.DTOMapper;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;

public class ApplicationsMapper implements DTOMapper<Applications, JobApplicationResponseDTO> {


    @Override
    public Applications apply(JobApplicationResponseDTO entity) {
        Applications applications = new Applications();
        applications.setId(entity.getApplicationId());
        applications.setApplicationStatus(entity.getApplicationStatus());
        applications.setDateApplied(entity.getAppliedAt());
        applications.setCvLink(entity.getCvLink());
        applications.setCoverLetter(entity.getCoverLetter());


        return applications;
    }
}
