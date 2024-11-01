package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.repositories.ApplicationsRepository;
import com.jobfinder.jobfinder.services.ApplicationsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ApplicationsServiceImpl implements ApplicationsService {

    @Autowired
    private final ApplicationsRepository applicationsRepository;

    public ApplicationsServiceImpl(ApplicationsRepository applicationsRepository) {
        this.applicationsRepository = applicationsRepository;
    }

    @Override
    public List<JobApplicationResponseDTO> getApplicationsByUser(Long id) {
        return null;
    }

//    @Override
//    public List<JobApplicationResponseDTO> getApplicationsByUser() {
//        JobApplicationMapper mapper = new JobApplicationMapper(new AppUserMapper(new Ski), new JobMapper());
//        List<JobApplicationResponseDTO> applications = applicationsRepository.findAll().stream().map(applications1 -> new JobApplicationMapper(applications1)).collect(Collectors.toList());
//        JobApplicationResponseDTO response = JobApplicationMapper.toDto(applicationsRepository.findAll());
//        return null;
//    }
}
