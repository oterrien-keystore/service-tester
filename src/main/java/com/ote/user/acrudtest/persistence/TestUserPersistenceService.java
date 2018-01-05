package com.ote.user.acrudtest.persistence;

import com.ote.crud.AdtPersistenceService;
import com.ote.crud.IEntityRepository;
import com.ote.crud.IMapperService;
import com.ote.user.acrudtest.restcontroller.TestUserPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestUserPersistenceService extends AdtPersistenceService<TestUserPayload, TestUserEntity> {

    public TestUserPersistenceService(@Autowired IEntityRepository<TestUserEntity> entityRepository, @Autowired IMapperService<TestUserPayload, TestUserEntity> mapperService) {
        super(entityRepository, mapperService, TestUserPayload.getEntityName());
    }
}
