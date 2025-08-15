package com.jobfinder.jobfinder.models.entities;

import com.jobfinder.jobfinder.models.enums.Status;
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

    private String title;

    private String companyName;

    private String description;

    private String location;

    private String jobType;

    private Float salary;

    private String requirements;

    private LocalDateTime datePosted;

    private LocalDateTime applicationDeadline;

    private Boolean isRemote;

    private String experienceLevel;

    private Status status;


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

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
