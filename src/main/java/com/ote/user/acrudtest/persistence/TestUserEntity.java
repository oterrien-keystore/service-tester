package com.ote.user.acrudtest.persistence;

import com.ote.crud.model.IEntity;
import com.ote.user.acrudtest.restcontroller.TestUserPayload;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_USER_TEST")
public class TestUserEntity implements IEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD", nullable = false, length = 128)
    private String password;

    @Override
    public TestUserPayload convert() {
        TestUserPayload payload = new TestUserPayload();
        payload.setId(id);
        payload.setLogin(login);
        payload.setPassword(password);
        return payload;
    }
}
