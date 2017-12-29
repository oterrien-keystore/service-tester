package com.ote.user.acrudtest.persistence;

import com.ote.crud.IEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestUserRepository extends IEntityRepository<TestUserEntity> {

}

