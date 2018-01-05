package com.ote.user.acrudtest.restcontroller;

import com.ote.crud.AdtPersistenceRestController;
import com.ote.crud.IPersistenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/testUsers")
@Slf4j
public class TestUserRestController extends AdtPersistenceRestController<TestUserPayload> {

    public TestUserRestController(@Autowired IPersistenceService<TestUserPayload> persistenceService) {
        super(persistenceService, TestUserPayload.getEntityName());
    }
}
