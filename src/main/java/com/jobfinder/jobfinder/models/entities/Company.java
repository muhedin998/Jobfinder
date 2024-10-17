package com.jobfinder.jobfinder.models.entities;

import jakarta.persistence.*;
import lombok.Data;

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

    @OneToMany(mappedBy = "company")
    private Set<Job> jobs;
}