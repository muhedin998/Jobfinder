package com.jobfinder.jobfinder.services;

import com.jobfinder.jobfinder.models.dtos.request.JobApplicationRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ApplicationsService {

    List<JobApplicationResponseDTO> getApplicationsByUser(Long id);

    List<JobApplicationResponseDTO> getApplicationsByJob(Long id);

    void applyForJob(JobApplicationRequestDTO jobApplicationRequestDTO);

    void updateApplication(Long id, JobApplicationRequestDTO jobApplicationRequestDTO);

    void deleteApplication(Long id);
}
