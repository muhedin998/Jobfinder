package com.jobfinder.jobfinder.repositories;

import com.jobfinder.jobfinder.models.entities.AppUser;
import com.jobfinder.jobfinder.models.entities.Job;
import com.jobfinder.jobfinder.models.enums.Status;
import com.jobfinder.jobfinder.models.enums.JobType;
import com.jobfinder.jobfinder.models.enums.ExperienceLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    
    List<Job> findByStatus(Status status);
    
    List<Job> findByUserAndStatus(AppUser user, Status status);
    
    List<Job> findByUser(AppUser user);
    
    @Query("SELECT j FROM Job j WHERE " +
           "(:title IS NULL OR LOWER(j.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
           "(:location IS NULL OR LOWER(j.location) LIKE LOWER(CONCAT('%', :location, '%'))) AND " +
           "(:jobType IS NULL OR j.jobType = :jobType) AND " +
           "(:experienceLevel IS NULL OR j.experienceLevel = :experienceLevel) AND " +
           "(:isRemote IS NULL OR j.isRemote = :isRemote) AND " +
           "j.status = 'ACTIVE'")
    List<Job> searchJobs(@Param("title") String title,
                        @Param("location") String location,
                        @Param("jobType") JobType jobType,
                        @Param("experienceLevel") ExperienceLevel experienceLevel,
                        @Param("isRemote") Boolean isRemote);
}
