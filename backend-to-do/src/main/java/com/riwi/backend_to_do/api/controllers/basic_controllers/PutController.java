package com.riwi.backend_to_do.api.controllers.basic_controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PutController<RS, RQ> {
    @PutMapping("/{id}")
    public ResponseEntity<RS> update(@Validated @RequestBody RQ request, @PathVariable Long id);
}
