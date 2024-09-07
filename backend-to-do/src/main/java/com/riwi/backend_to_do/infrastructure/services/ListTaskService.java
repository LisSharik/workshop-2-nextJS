package com.riwi.backend_to_do.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.backend_to_do.api.dto.request.ListTaskRequest;
import com.riwi.backend_to_do.api.dto.response.ListTaskResponse;
import com.riwi.backend_to_do.domain.entities.ListTask;
import com.riwi.backend_to_do.domain.repositories.ListTaskRepository;
import com.riwi.backend_to_do.infrastructure.abstract_services.IListTaskService;
import com.riwi.backend_to_do.infrastructure.helpers.generic_methods.GenericEntityService;
import com.riwi.backend_to_do.infrastructure.helpers.mappers.ListTaskMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListTaskService implements IListTaskService {

    @Autowired
    private final ListTaskRepository listTaskRepository;

    @Autowired
    private final ListTaskMapper listTaskMapper;

    @Autowired
    private final GenericEntityService<ListTask, Long> genericListTaskService;

    @Override
    public Page<ListTaskResponse> getAll(int page, int size) {
        if (page < 0) {
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page, size);
        return this.listTaskRepository.findAll(pagination)
                .map(listTask -> this.listTaskMapper.toListTaskResponse(listTask));
    }

    @Override
    public ListTaskResponse get(Long id) {
        ListTask listTask = this.genericListTaskService.find(listTaskRepository, id, "ListTask");
        return this.listTaskMapper.toListTaskResponse(listTask);
    }

    @Override
    public ListTaskResponse create(ListTaskRequest request) {
        ListTask listTask = this.listTaskMapper.toListTaskEntity(request);
        listTask.setTasks(new ArrayList<>());
        return this.listTaskMapper.toListTaskResponse(this.listTaskRepository.save(listTask));
    }

    @Override
    public ListTaskResponse update(Long id, ListTaskRequest request) {
        ListTask listTask = this.genericListTaskService.find(listTaskRepository, id, "ListTask");
        listTask = this.listTaskMapper.toListTaskUpdateEntity(request, listTask);
        return this.listTaskMapper.toListTaskResponse(this.listTaskRepository.save(listTask));
    }

    @Override
    public void delete(Long id) {
        ListTask listTask = this.genericListTaskService.find(listTaskRepository, id, "ListTask");
        this.listTaskRepository.delete(listTask);
    }

}
