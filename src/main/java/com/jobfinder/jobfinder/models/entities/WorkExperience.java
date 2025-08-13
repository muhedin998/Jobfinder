package com.jobfinder.jobfinder.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkExperience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;
    
    private String jobTitle;
    
    private String companyName;
    
    private String location;
    
    private String employmentType;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private Boolean currentlyWorking;
    
    @Column(length = 2000)
    private String description;
    
    @Column(length = 1000)
    private String achievements;
    
    private Float salary;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}