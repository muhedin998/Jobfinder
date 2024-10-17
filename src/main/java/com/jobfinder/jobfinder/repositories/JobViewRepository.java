package com.jobfinder.jobfinder.repositories;

import com.jobfinder.jobfinder.models.entities.JobView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobViewRepository extends JpaRepository<JobView, Long> {
}
