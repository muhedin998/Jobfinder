package com.jobfinder.jobfinder.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobAlert {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
    
    private String alertName;
    
    private String keywords;
    
    private String location;
    
    private Float minSalary;
    
    private Float maxSalary;
    
    private String jobType;
    
    private String experienceLevel;
    
    private Boolean remoteWork;
    
    @ManyToMany
    @JoinTable(
            name = "job_alert_categories",
            joinColumns = @JoinColumn(name = "job_alert_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<JobCategory> categories;
    
    @ManyToMany
    @JoinTable(
            name = "job_alert_skills",
            joinColumns = @JoinColumn(name = "job_alert_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills;
    
    private Boolean isActive;
    
    private String frequency;
    
    private LocalDateTime lastSent;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        isActive = true;
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}