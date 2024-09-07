package com.riwi.backend_to_do.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.riwi.backend_to_do.api.dto.request.ListTaskRequest;
import com.riwi.backend_to_do.api.dto.response.ListTaskResponse;
import com.riwi.backend_to_do.api.dto.response.basic_response.ListTaskBasicResponse;
import com.riwi.backend_to_do.domain.entities.ListTask;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListTaskMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "tasks", ignore = true)
    })
    ListTask toListTaskEntity(ListTaskRequest request);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "tasks", ignore = true)
    })
    ListTask toListTaskUpdateEntity(ListTaskRequest request, @MappingTarget ListTask listTask);

    @InheritInverseConfiguration
    ListTaskBasicResponse toListTaskBasicResponse(ListTask listTask);

    @InheritInverseConfiguration
    ListTaskResponse toListTaskResponse(ListTask listTask);
}
