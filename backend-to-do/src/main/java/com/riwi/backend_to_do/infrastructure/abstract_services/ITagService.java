package com.riwi.backend_to_do.infrastructure.abstract_services;

import com.riwi.backend_to_do.api.dto.request.TagRequest;
import com.riwi.backend_to_do.api.dto.response.TagResponse;
import com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services.BasicCrudService;

public interface ITagService extends BasicCrudService<TagRequest, TagResponse, Long> {
    
}
