package com.riwi.backend_to_do.api.dto.response;

import java.util.List;

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
public class TagResponse extends TagBasicResponse {
    private List<TaskBasicResponse> tasks;
}
