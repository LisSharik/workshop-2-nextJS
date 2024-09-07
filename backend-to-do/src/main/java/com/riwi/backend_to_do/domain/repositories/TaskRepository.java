package com.riwi.backend_to_do.domain.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riwi.backend_to_do.domain.entities.Task;
import com.riwi.backend_to_do.util.enums.Status;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM task t WHERE t.status <> :status " +
           "AND (:tagId IS NULL OR t.tag.id = :tagId) " +
           "AND (:listTaskId IS NULL OR t.listTask.id = :listTaskId)")
    Page<Task> findByStatusNotAndFilters(
        @Param("status") Status status,
        @Param("tagId") Long tagId,
        @Param("listTaskId") Long listTaskId,
        Pageable pageable
    );
}
