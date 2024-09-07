package com.riwi.backend_to_do.infrastructure.abstract_services.basic_abstract_services;

public interface BasicCrudService<RQ, RS, ID> extends
        GetAllService<RS>,
        GetService<RS, ID>,
        CreateService<RQ, RS>,
        UpdateService<RQ, RS, ID>,
        DeleteService<ID> {

}
