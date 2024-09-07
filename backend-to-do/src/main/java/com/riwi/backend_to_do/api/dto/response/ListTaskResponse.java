package com.riwi.backend_to_do.api.dto.response;

import java.util.List;

import com.riwi.backend_to_do.api.dto.response.basic_response.ListTaskBasicResponse;
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
public class ListTaskResponse extends ListTaskBasicResponse {
    private List<TaskBasicResponse> tasks;
    
}
