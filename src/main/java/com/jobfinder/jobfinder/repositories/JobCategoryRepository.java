package com.jobfinder.jobfinder.repositories;

import com.jobfinder.jobfinder.models.entities.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Long> {
}
