package com.jobfinder.jobfinder.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Applications {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne()
    private AppUser applicant;

    @OneToOne
    private Job job;

    private LocalDate dateApplied;

    private Staus staus;
}

