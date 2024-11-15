package com.jobfinder.jobfinder.models.entities;

import com.jobfinder.jobfinder.models.dtos.mappers.JobCatergoryMapper;
import com.jobfinder.jobfinder.models.dtos.mappers.SkillMapper;
import com.jobfinder.jobfinder.models.dtos.mappers.UserMapper;
import com.jobfinder.jobfinder.models.dtos.request.JobRequestDTO;
import com.jobfinder.jobfinder.models.enums.JobStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String companyName;

    private String description;

    private String location;

    private String jobType;

    private Float salary;

    private String requirmnets;

    private LocalDateTime datePosted;

    private JobStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;


    @OneToMany(mappedBy = "job")
    private Set<Applications> applications;

    @ManyToMany
    @JoinTable(
            name = "job_skills",
            joinColumns = @JoinColumn(name = "job_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private JobCategory jobCategory;

    public static Job toEntity(JobRequestDTO jobRequestDTO) {
        Job job = new Job();
        job.setTitle(jobRequestDTO.getTitle());
        job.setCompanyName(jobRequestDTO.getCompanyName());
        job.setDescription(jobRequestDTO.getDescription());
        job.setLocation(jobRequestDTO.getLocation());
        job.setJobType(jobRequestDTO.getJobType());
        job.setSalary(Float.parseFloat(jobRequestDTO.getSalary()));
        job.setRequirmnets(jobRequestDTO.getRequirements());
        job.setDatePosted(LocalDateTime.now());
        job.setJobCategory(JobCatergoryMapper.INSTANCE.apply(jobRequestDTO.getCategory()));
        job.setSkills(jobRequestDTO.getSkill().stream().map(SkillMapper.INSTANCE::apply).collect(Collectors.toSet()));
        job.setStatus(JobStatus.ACTIVE);
        job.setUser(UserMapper.INSTANCE.apply(jobRequestDTO.getUser()));

        return job;
    }
}
