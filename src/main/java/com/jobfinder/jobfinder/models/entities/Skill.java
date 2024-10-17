package com.jobfinder.jobfinder.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    private String skillName;

    @ManyToMany(mappedBy = "skills")
    private Set<Job> jobs;

    @ManyToMany(mappedBy = "skills")
    private Set<AppUser> users;
}
