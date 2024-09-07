package com.riwi.backend_to_do.api.controllers.basic_controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PostController<RS,RQ> {
    @PostMapping
    public ResponseEntity<RS> insert(@Validated @RequestBody RQ request);
}
