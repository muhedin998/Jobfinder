package com.jobfinder.jobfinder.models.mappers;

import com.jobfinder.jobfinder.integration.DTOMapper;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;

public class ApplicationsMapper implements DTOMapper<Applications, JobApplicationResponseDTO> {


    @Override
    public Applications apply(JobApplicationResponseDTO entity) {
        Applications applications = new Applications();
        applications.setId(entity.getApplicationId());
        applications.setJob(entity.getJob());
        applications.setUser(entity.getUser());
        applications.setApplicationStatus(entity.getApplicationStatus());
        applications.setDateApplied(entity.getAppliedAt());
        applications.setCvLink();
        applications.setCoverLetter();


        return applications;
    }
}
