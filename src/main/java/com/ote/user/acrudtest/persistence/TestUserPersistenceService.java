package com.ote.user.acrudtest.persistence;

import com.ote.crud.AdtPersistenceService;
import com.ote.user.acrudtest.restcontroller.TestUserPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUserPersistenceService extends AdtPersistenceService<TestUserPayload, TestUserEntity> {

    @Autowired
    public TestUserPersistenceService(ITestUserRepository entityRepository, TestUserMapperService mapperService) {
        super(entityRepository, mapperService, "TestUser");
    }
}
