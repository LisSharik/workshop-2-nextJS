package com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services;

public interface CreateService<RQ, RP> {
    public RP create(RQ request);
}