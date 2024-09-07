package com.riwi.backend_to_do.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.backend_to_do.api.controllers.basic_controllers.BasicController;
import com.riwi.backend_to_do.api.dto.request.ListTaskRequest;
import com.riwi.backend_to_do.api.dto.response.ListTaskResponse;
import com.riwi.backend_to_do.infrastructure.abstract_services.IListTaskService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/list-tasks")
@AllArgsConstructor
public class ListTaskController implements BasicController<ListTaskResponse, ListTaskRequest> {

    @Autowired
    private final IListTaskService listTaskService;


    @Override
    public ResponseEntity<Page<ListTaskResponse>> getAll(int page, int size) {
        return ResponseEntity.ok(this.listTaskService.getAll(page - 1, size));
    }

    @Override
    public ResponseEntity<ListTaskResponse> getById(Long id) {
       return ResponseEntity.ok(this.listTaskService.get(id));
    }

    @Override
    public ResponseEntity<ListTaskResponse> insert(ListTaskRequest request) {
        return ResponseEntity.ok(this.listTaskService.create(request));
    }

    @Override
    public ResponseEntity<ListTaskResponse> update(ListTaskRequest request, Long id) {
        return ResponseEntity.ok(this.listTaskService.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.listTaskService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
