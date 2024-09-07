package com.riwi.backend_to_do.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.backend_to_do.api.dto.request.TagRequest;
import com.riwi.backend_to_do.api.dto.response.TagResponse;
import com.riwi.backend_to_do.domain.entities.Tag;
import com.riwi.backend_to_do.domain.repositories.TagRespository;
import com.riwi.backend_to_do.infrastructure.abstract_services.ITagService;
import com.riwi.backend_to_do.infrastructure.helpers.generic_methods.GenericEntityService;
import com.riwi.backend_to_do.infrastructure.helpers.mappers.TagMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TagService implements ITagService {

    @Autowired
    private final TagRespository tagRespository;

    @Autowired
    private final TagMapper tagMapper;

    @Autowired
    private final GenericEntityService<Tag, Long> genericTagService;

    @Override
    public Page<TagResponse> getAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page, size);
        return this.tagRespository.findAll(pagination)
                .map(tag -> this.tagMapper.toTagResponse(tag));
    }

    @Override
    public TagResponse get(Long id) {
        Tag tag = this.genericTagService.find(tagRespository, id, "Tag");
        return this.tagMapper.toTagResponse(tag);
    }

    @Override
    public TagResponse create(TagRequest request) {
        Tag tag = this.tagMapper.toTagEntity(request);
        tag.setTasks(new ArrayList<>());
        return this.tagMapper.toTagResponse(this.tagRespository.save(tag));
    }

    @Override
    public TagResponse update(Long id, TagRequest request) {
        Tag tag = this.genericTagService.find(tagRespository, id, "Tag");
        tag = this.tagMapper.toTagUpdateEntity(request, tag);
        return this.tagMapper.toTagResponse(this.tagRespository.save(tag));
    }

    @Override
    public void delete(Long id) {
        Tag tag = this.genericTagService.find(tagRespository, id, "Tag");
        this.tagRespository.delete(tag);
    }
}
