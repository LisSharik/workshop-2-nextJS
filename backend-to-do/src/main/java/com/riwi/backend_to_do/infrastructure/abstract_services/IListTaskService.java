package com.riwi.backend_to_do.infrastructure.abstract_services;

import com.riwi.backend_to_do.api.dto.request.ListTaskRequest;
import com.riwi.backend_to_do.api.dto.response.ListTaskResponse;
import com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services.BasicCrudService;

public interface IListTaskService extends BasicCrudService<ListTaskRequest, ListTaskResponse, Long> {
    
}
