package com.jobfinder.jobfinder.repositories;

import com.jobfinder.jobfinder.models.entities.SavedJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavedJobsRepository extends JpaRepository<SavedJob, Long> {
}
