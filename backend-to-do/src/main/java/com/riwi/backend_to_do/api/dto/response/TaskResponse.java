package com.riwi.backend_to_do.api.dto.response;

import com.riwi.backend_to_do.api.dto.response.basic_response.ListTaskBasicResponse;
import com.riwi.backend_to_do.api.dto.response.basic_response.TagBasicResponse;
import com.riwi.backend_to_do.api.dto.response.basic_response.TaskBasicResponse;
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
public class TaskResponse extends TaskBasicResponse {
    private ListTaskBasicResponse listTask;
    private TagBasicResponse tag; 
}
