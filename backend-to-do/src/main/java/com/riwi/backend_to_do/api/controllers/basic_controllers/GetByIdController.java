package com.riwi.backend_to_do.api.controllers.basic_controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface GetByIdController<RS> {
    @GetMapping("/{id}")
    public ResponseEntity<RS> getById(@PathVariable Long id);
}
