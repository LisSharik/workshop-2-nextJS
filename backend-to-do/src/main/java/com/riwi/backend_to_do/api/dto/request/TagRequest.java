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
public class TagRequest {
    @NotBlank(message = "Tag name is required")
    @Size(message = "Tag name must be between 1 and 250 characters", min = 1, max = 250)
    private String name;

    @NotBlank(message = "Tag color is required")
    @Size(message = "Tag color must be between 1 and 16 characters", min = 1, max = 16)
    private String color;
}
