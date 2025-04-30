package com.jobfinder.jobfinder.repositories;

import com.jobfinder.jobfinder.models.entities.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long> {
    @Query("SELECT a FROM Applications a WHERE a.user.id = :userId")
    List<Applications> findByUserId(@Param("userId") Long userId);

    @Query("SELECT a FROM Applications a WHERE a.job.id = :jobId")
    List<Applications> findByJobId(@Param("jobId") Long jobId);
}
