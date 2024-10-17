package com.jobfinder.jobfinder.models.entities;

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
}

