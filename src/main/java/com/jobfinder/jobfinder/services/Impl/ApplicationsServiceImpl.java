package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.exceptions.InvalidDataException;
import com.jobfinder.jobfinder.models.dtos.mappers.ApplicationDTOMapper;
import com.jobfinder.jobfinder.models.dtos.request.JobApplicationRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;
import com.jobfinder.jobfinder.repositories.ApplicationsRepository;
import com.jobfinder.jobfinder.services.ApplicationsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ApplicationsServiceImpl implements ApplicationsService {

    @Autowired
    private final ApplicationsRepository applicationsRepository;
    
    @Autowired
    private ApplicationDTOMapper applicationDTOMapper;

    public ApplicationsServiceImpl(ApplicationsRepository applicationsRepository) {
        this.applicationsRepository = applicationsRepository;
    }

    @Override
    public List<JobApplicationResponseDTO> getApplicationsByUser(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidDataException("User ID must be a positive number");
        }
        
        List<Applications> applications = applicationsRepository.findByUserId(id);
        
        return applications.stream()
                .map(application -> applicationDTOMapper.apply(application, application.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<JobApplicationResponseDTO> getApplicationsByJob(Long id) {
        return List.of();
    }

    @Override
    public void applyForJob(JobApplicationRequestDTO jobApplicationRequestDTO) {

    }

    @Override
    public void updateApplication(Long id, JobApplicationRequestDTO jobApplicationRequestDTO) {

    }

    @Override
    public void deleteApplication(Long id) {

    }
}
