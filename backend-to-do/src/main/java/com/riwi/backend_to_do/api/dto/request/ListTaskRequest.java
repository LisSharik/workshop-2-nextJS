package com.riwi.backend_to_do.api.dto.request;

import jakarta.validation.constraints.NotBlank;
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
public class ListTaskRequest {
    @NotBlank(message = "List task name is required")    
    @Size(message = "List task name must be between 1 and 250 characters", min = 1, max = 250)
    private String name;

    @Size(message = "List task description must be between 0 and 500 characters", max = 500)
    @NotBlank(message = "List task description is required")
    private String description;
}
