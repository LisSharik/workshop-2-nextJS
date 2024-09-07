package com.riwi.backend_to_do.api.controllers.basic_controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.backend_to_do.api.dto.response.TaskResponse;

@RestController
public interface GetAllFilterTasks {
    @GetMapping
    public Page<TaskResponse> getAllFilterTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long tagId,
            @RequestParam(required = false) Long listTaskId);
}
