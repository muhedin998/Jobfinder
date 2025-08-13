package com.jobfinder.jobfinder.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyReview {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser reviewer;
    
    private Integer overallRating;
    
    private Integer workLifeBalanceRating;
    
    private Integer salaryRating;
    
    private Integer cultureRating;
    
    private Integer managementRating;
    
    private String jobTitle;
    
    private String employmentStatus;
    
    @Column(length = 2000)
    private String pros;
    
    @Column(length = 2000)
    private String cons;
    
    @Column(length = 1000)
    private String advice;
    
    private Boolean recommendToFriend;
    
    private Boolean approveOfCeo;
    
    private Boolean isAnonymous;
    
    private Boolean isVerified;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        isVerified = false;
        isAnonymous = true;
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}