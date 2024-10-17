package com.jobfinder.jobfinder.models.dtos.request;

import java.util.Set;

public class JobRequestDTO {
    private String title;
    private String description;
    private String requirements;
    private String location;
    private String jobType;
    private String salary;
    private Long categoryId;
    private Set<Long> skillIds;
    private String companyName;
}
