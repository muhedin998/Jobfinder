package com.jobfinder.jobfinder.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String location;

    @Column(length = 5000)
    private String description;

    private String website;

    private String industry;

    private String companySize;

    private String logoUrl;

    private Integer foundedYear;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "company")
    private Set<Job> jobs;

    @OneToMany(mappedBy = "company")
    private List<CompanyReview> companyReviews;

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