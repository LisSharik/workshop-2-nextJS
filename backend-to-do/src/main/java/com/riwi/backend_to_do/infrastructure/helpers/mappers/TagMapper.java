package com.riwi.backend_to_do.infrastructure.helpers.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.riwi.backend_to_do.api.dto.request.TagRequest;
import com.riwi.backend_to_do.api.dto.response.TagResponse;
import com.riwi.backend_to_do.api.dto.response.basic_response.TagBasicResponse;
import com.riwi.backend_to_do.domain.entities.Tag;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "tasks", ignore = true)
    })
    Tag toTagEntity(TagRequest request);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "tasks", ignore = true)
    })
    Tag toTagUpdateEntity(TagRequest request, @MappingTarget Tag tag);

    @InheritInverseConfiguration
    TagBasicResponse toTagBasicResponse(Tag tag);

    @InheritInverseConfiguration
    TagResponse toTagResponse(Tag tag);
}
