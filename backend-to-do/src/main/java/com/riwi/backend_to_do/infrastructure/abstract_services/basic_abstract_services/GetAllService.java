package com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services;

import org.springframework.data.domain.Page;

public interface GetAllService<RS> {
    public Page<RS> getAll(int page, int size);
}
