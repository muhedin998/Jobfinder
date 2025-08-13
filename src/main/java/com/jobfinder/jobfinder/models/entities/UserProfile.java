package com.jobfinder.jobfinder.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private AppUser user;
    
    @Column(length = 2000)
    private String bio;
    
    private String phone;
    
    private String address;
    
    private String city;
    
    private String country;
    
    private String website;
    
    private String linkedinUrl;
    
    private String githubUrl;
    
    private LocalDate dateOfBirth;
    
    private String profileImageUrl;
    
    @Column(length = 1000)
    private String summary;
    
    private Integer yearsOfExperience;
    
    private Float expectedSalary;
    
    private String currentJobTitle;
    
    private Boolean availableForWork;
    
    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Education> educations;
    
    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkExperience> workExperiences;
    
    @OneToMany(mappedBy = "userProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resume> resumes;
    
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