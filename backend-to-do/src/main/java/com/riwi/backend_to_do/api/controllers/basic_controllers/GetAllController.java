package com.riwi.backend_to_do.api.controllers.basic_controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public interface GetAllController<RS> {
    @GetMapping
    public ResponseEntity<Page<RS>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size);

}
