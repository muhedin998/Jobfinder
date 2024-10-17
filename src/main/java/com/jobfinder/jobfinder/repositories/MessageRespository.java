package com.jobfinder.jobfinder.repositories;

import com.jobfinder.jobfinder.models.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRespository extends JpaRepository<Message, Long> {
}
