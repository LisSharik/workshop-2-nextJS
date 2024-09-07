package com.riwi.backend_to_do.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.backend_to_do.api.dto.request.TaskRequest;
import com.riwi.backend_to_do.api.dto.response.TaskResponse;
import com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services.CreateService;
import com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services.DeleteService;
import com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services.GetService;
import com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services.UpdateService;

public interface ITaskService extends
        GetService<TaskResponse, Long>,
        CreateService<TaskRequest, TaskResponse>,
        DeleteService<Long>,
        UpdateService<TaskRequest, TaskResponse, Long> {
    Page<TaskResponse> getAll(int page, int size, Long tagId, Long listTaskId);
}
