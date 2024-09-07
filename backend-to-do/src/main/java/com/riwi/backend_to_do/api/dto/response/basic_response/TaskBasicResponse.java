package com.riwi.backend_to_do.api.dto.response.basic_response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.riwi.backend_to_do.util.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class TaskBasicResponse {
    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private LocalDateTime creationDate;
    private Status status;

}
