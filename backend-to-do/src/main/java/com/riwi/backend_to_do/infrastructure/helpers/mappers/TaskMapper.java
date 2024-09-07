package com.riwi.backend_to_do.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.riwi.backend_to_do.api.dto.request.TaskRequest;
import com.riwi.backend_to_do.api.dto.response.TaskResponse;
import com.riwi.backend_to_do.api.dto.response.basic_response.TaskBasicResponse;
import com.riwi.backend_to_do.domain.entities.Task;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    
    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "creationDate", ignore = true),
        @Mapping(target = "listTask", ignore = true),
        @Mapping(target = "tag", ignore = true)
    })
    Task toTaskEntity(TaskRequest request);

    @Mappings({
        @Mapping(target = "id", ignore = true),
        @Mapping(target = "creationDate", ignore = true),
        @Mapping(target = "listTask", ignore = true),
        @Mapping(target = "tag", ignore = true)
    })
    Task toTaskUpdateEntity(TaskRequest request, @MappingTarget Task task);

    @InheritInverseConfiguration
    TaskBasicResponse toTaskBasicResponse(Task task);

    @InheritInverseConfiguration
    TaskResponse toTaskResponse(Task task);
}
