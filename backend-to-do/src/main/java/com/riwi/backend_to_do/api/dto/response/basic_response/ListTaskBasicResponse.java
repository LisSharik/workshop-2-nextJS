package com.riwi.backend_to_do.api.dto.response.basic_response;

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
public class ListTaskBasicResponse {
    private Long id;
    private String name;
    private String description;
    
}
