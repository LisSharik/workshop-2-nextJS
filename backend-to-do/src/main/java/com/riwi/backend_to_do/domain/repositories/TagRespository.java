package com.riwi.backend_to_do.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.backend_to_do.domain.entities.Tag;

@Repository
public interface TagRespository extends JpaRepository<Tag, Long> {
    
}
