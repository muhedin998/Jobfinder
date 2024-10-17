package com.jobfinder.jobfinder.repositories;

import com.jobfinder.jobfinder.models.entities.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationsRepository extends JpaRepository<Applications, Long> {
}
