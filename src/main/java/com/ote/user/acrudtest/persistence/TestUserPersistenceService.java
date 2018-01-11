package com.ote.user.acrudtest.persistence;

import com.ote.crud.IEntityRepository;
import com.ote.crud.IPersistenceService;
import com.ote.user.acrudtest.restcontroller.TestUserPayload;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestUserPersistenceService implements IPersistenceService<TestUserPayload> {

    @Autowired
    @Getter
    private IEntityRepository<TestUserEntity> entityRepository;

    @Getter
    private String entityName = TestUserPayload.getEntityName();

    @Value("${page.default.size}")
    @Getter
    private int defaultPageSize;


}
