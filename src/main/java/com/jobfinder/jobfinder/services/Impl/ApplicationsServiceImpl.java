package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.models.dtos.request.JobApplicationRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.entities.Applications;
import com.jobfinder.jobfinder.models.enums.JobStatus;
import com.jobfinder.jobfinder.models.enums.Staus;
import com.jobfinder.jobfinder.repositories.ApplicationsRepository;
import com.jobfinder.jobfinder.services.ApplicationsService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplicationsServiceImpl implements ApplicationsService {

    private final ApplicationsRepository applicationsRepository;

    @Override
    public List<JobApplicationResponseDTO> getApplicationsByUser(Long id) {
        List<Applications> applications = applicationsRepository.findByUserId(id);
        return applications.stream().map(applications1 -> new JobApplicationResponseDTO()).collect(Collectors.toList());
    }

    @Override
    public List<JobApplicationResponseDTO> getApplicationsByJob(Long id) {
        List<Applications> applications = applicationsRepository.findByJobId(id);
        return applications.stream().map(applications1 -> new JobApplicationResponseDTO()).collect(Collectors.toList());
    }

    @Override
    public void applyForJob(JobApplicationRequestDTO jobApplicationRequestDTO) {
        Applications applicatoin = new Applications().toEntity(jobApplicationRequestDTO);
        applicationsRepository.save(applicatoin);
    }


    @Override
    public void deleteApplication(Long id) {

    }

    @Override
    public void updateApplication(Long id, JobApplicationRequestDTO jobApplicationRequestDTO) {
        Applications application = applicationsRepository.findById(id).orElseThrow(() -> new RuntimeException("Application not found"));
        application.setApplicationStatus(JobStatus.ACTIVE);
        applicationsRepository.save(application);
    }



//    @Override
//    public List<JobApplicationResponseDTO> getApplicationsByUser() {
//        JobApplicationMapper mapper = new JobApplicationMapper(new AppUserMapper(new Ski), new JobMapper());
//        List<JobApplicationResponseDTO> applications = applicationsRepository.findAll().stream().map(applications1 -> new JobApplicationMapper(applications1)).collect(Collectors.toList());
//        JobApplicationResponseDTO response = JobApplicationMapper.toDto(applicationsRepository.findAll());
//        return null;
//    }
}
