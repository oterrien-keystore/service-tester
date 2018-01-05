package com.ote.user.acrudtest.restcontroller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ote.crud.model.IPayload;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TestUserPayload implements IPayload {

    @Getter
    public static final String EntityName = "TestUser";

    private long id;

    @NotNull(groups = {CreatingValidationType.class, ResettingValidationType.class})
    private String login;

    @NotNull(groups = {CreatingValidationType.class, ResettingValidationType.class})
    @JsonIgnore
    private String password;
}
