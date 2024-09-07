package com.riwi.backend_to_do.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.backend_to_do.api.controllers.basic_controllers.BasicController;
import com.riwi.backend_to_do.api.dto.request.TagRequest;
import com.riwi.backend_to_do.api.dto.response.TagResponse;
import com.riwi.backend_to_do.infrastructure.abstract_services.ITagService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tags")
@AllArgsConstructor
public class TagController implements BasicController<TagResponse, TagRequest> {

    @Autowired
    private final ITagService tagService;
    
    @Override
    public ResponseEntity<Page<TagResponse>> getAll(int page, int size) {
        return ResponseEntity.ok(this.tagService.getAll(page - 1, size));
    }

    @Override
    public ResponseEntity<TagResponse> getById(Long id) {
        return ResponseEntity.ok(this.tagService.get(id));
    }

    @Override
    public ResponseEntity<TagResponse> insert(TagRequest request) {
        return ResponseEntity.ok(this.tagService.create(request));
    }

    @Override
    public ResponseEntity<TagResponse> update(TagRequest request, Long id) {
        return ResponseEntity.ok(this.tagService.update(id, request));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        this.tagService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
