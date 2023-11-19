package com.jobfinder.jobfinder.repositories;

import com.jobfinder.jobfinder.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}
