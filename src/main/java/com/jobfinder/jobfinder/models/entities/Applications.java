package com.jobfinder.jobfinder.models.entities;

import com.jobfinder.jobfinder.models.dtos.mappers.JobMapper;
import com.jobfinder.jobfinder.models.dtos.mappers.UserMapper;
import com.jobfinder.jobfinder.models.dtos.request.JobApplicationRequestDTO;
import com.jobfinder.jobfinder.models.dtos.response.JobApplicationResponseDTO;
import com.jobfinder.jobfinder.models.enums.Staus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Applications {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String applicationStatus;

    private String coverLetter;

    private String cvLink;

    private LocalDateTime dateApplied;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @ManyToOne()
    @JoinColumn(name = "job_id")
    private Job job;

    public Applications toEntity(JobApplicationRequestDTO jobApplicationRequestDTO) {
        Applications applications = new Applications();
        applications.setApplicationStatus(Staus.PENDING.toString());
        applications.setCoverLetter(jobApplicationRequestDTO.getCoverLetter());
        applications.setCvLink(jobApplicationRequestDTO.getCvLink());
        applications.setUser(UserMapper.INSTANCE.apply(jobApplicationRequestDTO.getUser()));
        applications.setJob(JobMapper.INSTANCE.apply(jobApplicationRequestDTO.getJob()));
        applications.setDateApplied(LocalDateTime.now());
        return applications;
    }
}

