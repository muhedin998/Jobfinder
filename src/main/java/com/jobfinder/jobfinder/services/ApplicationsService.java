package com.jobfinder.jobfinder.services;

import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ApplicationsService {

    List<JobApplicationResponseDTO> getApplicationsByUser(Long id);
}
