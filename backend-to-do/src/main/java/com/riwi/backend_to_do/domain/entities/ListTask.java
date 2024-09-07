package com.riwi.backend_to_do.domain.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "list_task")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ListTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String name;

    @Lob
    private String description;

    @OneToMany(mappedBy = "listTask", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Task> tasks;
}
