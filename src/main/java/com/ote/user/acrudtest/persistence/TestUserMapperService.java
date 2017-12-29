package com.ote.user.acrudtest.persistence;

import com.ote.crud.IMapperService;
import com.ote.crud.model.Filter;
import com.ote.user.acrudtest.restcontroller.TestUserPayload;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class TestUserMapperService implements IMapperService<TestUserPayload, TestUserEntity> {

    @Override
    public TestUserEntity convert(TestUserPayload payload) {
        TestUserEntity entity = new TestUserEntity();
        entity.setId(payload.getId());
        entity.setLogin(payload.getLogin());
        entity.setPassword(payload.getPassword());
        return entity;
    }

    @Override
    public TestUserPayload convert(TestUserEntity entity) {
        TestUserPayload payload = new TestUserPayload();
        payload.setId(entity.getId());
        payload.setLogin(entity.getLogin());
        payload.setPassword(entity.getPassword());
        return payload;
    }
}
