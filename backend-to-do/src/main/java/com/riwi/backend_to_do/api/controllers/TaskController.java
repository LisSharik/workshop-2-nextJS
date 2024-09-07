package com.riwi.backend_to_do.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.backend_to_do.api.controllers.basic_controllers.DeleteController;
import com.riwi.backend_to_do.api.controllers.basic_controllers.GetAllFilterTasks;
import com.riwi.backend_to_do.api.controllers.basic_controllers.GetByIdController;
import com.riwi.backend_to_do.api.controllers.basic_controllers.PostController;
import com.riwi.backend_to_do.api.controllers.basic_controllers.PutController;
import com.riwi.backend_to_do.api.dto.request.TaskRequest;
import com.riwi.backend_to_do.api.dto.response.TaskResponse;
import com.riwi.backend_to_do.infrastructure.abstract_services.ITaskService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
@CrossOrigin("*")
public class TaskController implements 
GetByIdController<TaskResponse>, 
PostController <TaskResponse, TaskRequest>,
PutController<TaskResponse, TaskRequest>,
GetAllFilterTasks,
DeleteController
{

    @Autowired
    private final ITaskService taskService;

  
    @Override
    public ResponseEntity<TaskResponse> getById(Long id) {
        return ResponseEntity.ok(this.taskService.get(id));
    }

    @Override
    public ResponseEntity<TaskResponse> insert(TaskRequest request) {
        return ResponseEntity.ok(this.taskService.create(request));
    }

    @Override
    public ResponseEntity<TaskResponse> update(TaskRequest request, Long id) {
        return ResponseEntity.ok(this.taskService.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.taskService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public Page<TaskResponse> getAllFilterTasks(int page, int size, Long tagId, Long listTaskId) {
        return this.taskService.getAll(page - 1, size, tagId, listTaskId);
    }

   

}
