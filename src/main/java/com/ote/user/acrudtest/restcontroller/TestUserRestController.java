package com.ote.user.acrudtest.restcontroller;

import com.ote.crud.IPersistenceRestController;
import com.ote.crud.IPersistenceService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/testUsers")
@Slf4j
@Validated
public class TestUserRestController implements IPersistenceRestController<TestUserPayload> {

    @Autowired
    @Getter
    private IPersistenceService<TestUserPayload> persistenceService;

    @Getter
    private String entityName = TestUserPayload.getEntityName();
}
