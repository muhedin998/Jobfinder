package com.jobfinder.jobfinder.services.Impl;

import com.jobfinder.jobfinder.exceptions.InvalidDataException;
import com.jobfinder.jobfinder.exceptions.ResourceNotFoundException;
import com.jobfinder.jobfinder.models.dtos.mappers.JobMapperComponent;
import com.jobfinder.jobfinder.models.dtos.request.CreateJobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.request.UpdateJobRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobResponseDTO;
import com.jobfinder.jobfinder.models.entities.AppUser;
import com.jobfinder.jobfinder.models.entities.Job;
import com.jobfinder.jobfinder.models.entities.JobCategory;
import com.jobfinder.jobfinder.models.entities.Skill;
import com.jobfinder.jobfinder.models.enums.Status;
import com.jobfinder.jobfinder.models.enums.JobType;
import com.jobfinder.jobfinder.models.enums.ExperienceLevel;
import com.jobfinder.jobfinder.repositories.JobRepository;
import com.jobfinder.jobfinder.repositories.JobCategoryRepository;
import com.jobfinder.jobfinder.repositories.SkillRepository;
import com.jobfinder.jobfinder.repositories.AppUserRepository;
import com.jobfinder.jobfinder.services.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private JobCategoryRepository categoryRepository;
    
    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    private AppUserRepository userRepository;
    
    @Autowired
    private JobMapperComponent jobMapper;

    public JobResponseDTO createJob(CreateJobRequestDTO request) {
        validateJobRequest(request);
        
        // Get authenticated user from security context
        AppUser currentUser = getCurrentAuthenticatedUser();
        
        Job job = Job.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .requirements(request.getRequirements())
                .location(request.getLocation())
                .jobType(request.getJobType())
                .salary(request.getSalary())
                .companyName(request.getCompanyName())
                .experienceLevel(request.getExperienceLevel())
                .isRemote(request.getIsRemote())
                .applicationDeadline(request.getApplicationDeadline())
                .benefits(request.getBenefits())
                .positions(request.getPositions())
                .isDraft(request.getIsDraft())
                .datePosted(LocalDateTime.now())
                .status(request.getIsDraft() ? Status.DRAFT : Status.ACTIVE)
                .user(currentUser)
                .build();
        
        // Set category if provided
        if (request.getCategoryId() != null) {
            JobCategory category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Job Category", "id", request.getCategoryId()));
            job.setJobCategory(category);
        }
        
        // Set skills if provided
        if (request.getSkillIds() != null && !request.getSkillIds().isEmpty()) {
            Set<Skill> skills = new HashSet<>();
            for (Long skillId : request.getSkillIds()) {
                Skill skill = skillRepository.findById(skillId)
                        .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));
                skills.add(skill);
            }
            job.setSkills(skills);
        }
        
        Job savedJob = jobRepository.save(job);
        return mapToResponseDTO(savedJob);
    }
    
    public JobResponseDTO updateJob(Long jobId, UpdateJobRequestDTO request) {
        Job existingJob = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", jobId));
        
        // Security check - only job creator or admin can update
        AppUser currentUser = getCurrentAuthenticatedUser();
        if (!existingJob.getUser().getId().equals(currentUser.getId()) && 
            !currentUser.getRole().name().equals("ADMIN")) {
            throw new InvalidDataException("You can only update your own jobs");
        }
        
        // Update fields if provided
        if (request.getTitle() != null) {
            existingJob.setTitle(request.getTitle());
        }
        if (request.getDescription() != null) {
            existingJob.setDescription(request.getDescription());
        }
        if (request.getRequirements() != null) {
            existingJob.setRequirements(request.getRequirements());
        }
        if (request.getLocation() != null) {
            existingJob.setLocation(request.getLocation());
        }
        if (request.getJobType() != null) {
            existingJob.setJobType(request.getJobType());
        }
        if (request.getSalary() != null) {
            existingJob.setSalary(request.getSalary());
        }
        if (request.getCompanyName() != null) {
            existingJob.setCompanyName(request.getCompanyName());
        }
        if (request.getExperienceLevel() != null) {
            existingJob.setExperienceLevel(request.getExperienceLevel());
        }
        if (request.getIsRemote() != null) {
            existingJob.setIsRemote(request.getIsRemote());
        }
        if (request.getApplicationDeadline() != null) {
            existingJob.setApplicationDeadline(request.getApplicationDeadline());
        }
        if (request.getStatus() != null) {
            existingJob.setStatus(request.getStatus());
        }
        
        // Update category if provided
        if (request.getCategoryId() != null) {
            JobCategory category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Job Category", "id", request.getCategoryId()));
            existingJob.setJobCategory(category);
        }
        
        // Update skills if provided
        if (request.getSkillIds() != null) {
            Set<Skill> skills = new HashSet<>();
            for (Long skillId : request.getSkillIds()) {
                Skill skill = skillRepository.findById(skillId)
                        .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));
                skills.add(skill);
            }
            existingJob.setSkills(skills);
        }
        
        Job updatedJob = jobRepository.save(existingJob);
        return mapToResponseDTO(updatedJob);
    }
    
    public List<Job> getAllJobs() {
        return jobRepository.findByStatus(Status.ACTIVE);
    }
    
    public List<Job> searchJobs(String title, String location, JobType jobType, 
                               ExperienceLevel experienceLevel, Boolean isRemote) {
        return jobRepository.searchJobs(title, location, jobType, experienceLevel, isRemote);
    }
    
    public List<Job> getJobsByCurrentUser() {
        AppUser currentUser = getCurrentAuthenticatedUser();
        return jobRepository.findByUser(currentUser);
    }
    
    public Job getJobById(Long id) {
        if (id == null || id <= 0) {
            throw new InvalidDataException("Job ID must be a positive number");
        }
        
        return jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", id));
    }
    
    public void deleteJob(Long id) {
        Job job = getJobById(id);
        
        // Security check - only job creator or admin can delete
        AppUser currentUser = getCurrentAuthenticatedUser();
        if (!job.getUser().getId().equals(currentUser.getId()) && 
            !currentUser.getRole().name().equals("ADMIN")) {
            throw new InvalidDataException("You can only delete your own jobs");
        }
        
        jobRepository.delete(job);
    }
    
    private AppUser getCurrentAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new InvalidDataException("User must be authenticated to perform this action");
        }
        
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }
    
    private void validateJobRequest(CreateJobRequestDTO request) {
        if (request == null) {
            throw new InvalidDataException("Job request cannot be null");
        }
        
        if (request.getApplicationDeadline() != null && 
            request.getApplicationDeadline().isBefore(LocalDateTime.now())) {
            throw new InvalidDataException("Application deadline cannot be in the past");
        }
    }
    
    private JobResponseDTO mapToResponseDTO(Job job) {
        return jobMapper.toResponseDto(job);
    }
}