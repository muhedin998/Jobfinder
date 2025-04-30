package com.jobfinder.jobfinder.models.entities;

import com.jobfinder.jobfinder.models.enums.JobStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titel;

    private String companyName;

    private String description;

    private String location;

    private String jobType;

    private Float salary;

    private String requirmnets;

    private LocalDateTime datePosted;

    private JobStatus status;

    @ManyToOne
    private Company company;
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
}
