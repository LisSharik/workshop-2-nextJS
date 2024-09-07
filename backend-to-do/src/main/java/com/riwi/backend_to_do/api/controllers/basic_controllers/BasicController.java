package com.riwi.backend_to_do.api.controllers.basic_controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public interface BasicController<RS, RQ> extends
        GetAllController<RS>,
        GetByIdController<RS>,
        PostController<RS, RQ>,
        PutController<RS, RQ>,
        DeleteController {

}
