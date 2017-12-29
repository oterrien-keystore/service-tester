package com.ote.user.acrudtest.restcontroller;

import com.ote.crud.model.IPayload;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class TestUserPayload implements IPayload {

    private long id;

    @NotNull(groups = {Creating.class, Resetting.class})
    private String login;

    @NotNull(groups = {Creating.class, Resetting.class})
    private String password;

    public interface Creating {
    }

    public interface Resetting {
    }

    public interface Merging {
    }
}
