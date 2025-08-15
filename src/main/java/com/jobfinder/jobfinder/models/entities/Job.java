package com.jobfinder.jobfinder.models.entities;

import com.jobfinder.jobfinder.models.enums.Status;
import com.jobfinder.jobfinder.models.enums.JobType;
import com.jobfinder.jobfinder.models.enums.ExperienceLevel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String companyName;

    private String description;

    private String location;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Column(precision = 10, scale = 2)
    private BigDecimal salary;

    private String requirements;

    private LocalDateTime datePosted;

    private LocalDateTime applicationDeadline;

    private Boolean isRemote;

    @Enumerated(EnumType.STRING)
    private ExperienceLevel experienceLevel;

    @Enumerated(EnumType.STRING)
    private Status status;
    
    @Column(length = 1000)
    private String benefits;
    
    @Column(name = "positions_available")
    private Integer positions;
    
    @Column(name = "is_draft")
    @Builder.Default
    private Boolean isDraft = false;


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
