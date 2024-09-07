package com.riwi.backend_to_do.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.backend_to_do.domain.entities.ListTask;

@Repository
public interface ListTaskRepository extends JpaRepository<ListTask, Long> {
    
}
