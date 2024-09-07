package com.riwi.backend_to_do.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.backend_to_do.api.dto.request.TaskRequest;
import com.riwi.backend_to_do.api.dto.response.TaskResponse;
import com.riwi.backend_to_do.domain.entities.ListTask;
import com.riwi.backend_to_do.domain.entities.Tag;
import com.riwi.backend_to_do.domain.entities.Task;
import com.riwi.backend_to_do.domain.repositories.ListTaskRepository;
import com.riwi.backend_to_do.domain.repositories.TagRespository;
import com.riwi.backend_to_do.domain.repositories.TaskRepository;
import com.riwi.backend_to_do.infrastructure.abstract_services.ITaskService;
import com.riwi.backend_to_do.infrastructure.helpers.generic_methods.GenericEntityService;
import com.riwi.backend_to_do.infrastructure.helpers.mappers.TaskMapper;
import com.riwi.backend_to_do.util.enums.Status;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService implements ITaskService {

    @Autowired
    private final TaskRepository taskRepository;

    @Autowired
    private final TaskMapper taskMapper;

    @Autowired
    private final TagRespository tagRepository;

    @Autowired
    private final ListTaskRepository listTaskRepository;

    @Autowired
    private final GenericEntityService<Task, Long> genericTaskService;

    @Autowired
    private final GenericEntityService<ListTask, Long> genericListTaskService;

    @Autowired
    private final GenericEntityService<Tag, Long> genericTagService;

    @Override
    public TaskResponse get(Long id) {
        Task task = this.genericTaskService.find(taskRepository, id, "Task");
        return this.taskMapper.toTaskResponse(task);
    }

    @Override
    public TaskResponse create(TaskRequest request) {
        Task task = this.taskMapper.toTaskEntity(request);

        ListTask listTask = this.genericListTaskService.find(listTaskRepository, request.getListTaskId(), "ListTask");
        task.setListTask(listTask);

        Tag tag = this.genericTagService.find(tagRepository, request.getTagId(), "Tag");
        task.setTag(tag);

        return this.taskMapper.toTaskResponse(this.taskRepository.save(task));
    }

    @Override
    public TaskResponse update(Long id, TaskRequest request) {
        Task task = this.genericTaskService.find(taskRepository, id, "Task");
        Task updatedTask = this.taskMapper.toTaskUpdateEntity(request, task);
        this.taskRepository.save(updatedTask);
        return this.taskMapper.toTaskResponse(updatedTask);
    }

    @Override
    public void delete(Long id) {
        Task task = this.genericTaskService.find(taskRepository, id, "Task");
        task.setStatus(Status.DELETED);
        this.taskRepository.save(task);
    }

    @Override
    public Page<TaskResponse> getAll(int page, int size, Long tagId, Long listTaskId) {
        if (page < 0) {
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page, size);

        return this.taskRepository.findByStatusNotAndFilters(Status.DELETED, tagId, listTaskId, pagination)
                .map(task -> this.taskMapper.toTaskResponse(task));
    }
}
