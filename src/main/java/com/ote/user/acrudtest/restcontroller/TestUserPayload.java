package com.ote.user.acrudtest.restcontroller;

import com.ote.crud.model.IEntity;
import com.ote.crud.model.IPayload;
import com.ote.user.acrudtest.persistence.TestUserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class TestUserPayload implements IPayload {

    @Getter
    public static final String EntityName = "TestUser";

    private long id;

    @NotEmpty(groups = {CreatingValidationType.class, ResettingValidationType.class})
    private String login;

    @NotEmpty(groups = {CreatingValidationType.class, ResettingValidationType.class})
    private String password;

    @Override
    public TestUserEntity convert() {
        TestUserEntity entity = new TestUserEntity();
        entity.setId(id);
        entity.setLogin(login);
        entity.setPassword(password);
        return entity;
    }
}
