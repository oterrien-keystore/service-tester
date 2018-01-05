package com.ote.user.acrudtest.restcontroller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ote.crud.model.IPayload;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

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
}
