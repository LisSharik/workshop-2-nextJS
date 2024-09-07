package com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services;

public interface UpdateService<RQ, RS, ID> {
    public RS update(ID id, RQ request);
}
