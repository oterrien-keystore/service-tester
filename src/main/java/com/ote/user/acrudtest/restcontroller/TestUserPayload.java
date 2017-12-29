package com.ote.user.acrudtest.restcontroller;

import com.ote.crud.model.IPayload;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TestUserPayload implements IPayload {

    private long id;

    private String login;

    private String password;
}
