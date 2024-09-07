package com.riwi.backend_to_do.api.dto.request;

import java.time.LocalDate;

import com.riwi.backend_to_do.util.enums.Status;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class TaskRequest {

    @NotBlank(message = "Task name is required")
    @Size(message = "Task name must be between 1 and 250 characters", min = 1, max = 250)
    private String name;

    @NotBlank(message = "Task description is required")
    @Size(message = "Task description must be between 1 and 500 characters", min = 1, max = 500)
    private String description;

    @NotNull(message = "Task date is required")
    @FutureOrPresent(message = "Task date must be in the future or present")
    private LocalDate date;

    @NotNull(message = "Task status is required")
    private Status status;

    @NotNull(message = "Task listTaskId is required")
    private Long listTaskId;

    @NotNull(message = "Task tagId is required") 
    private Long tagId; 
}
