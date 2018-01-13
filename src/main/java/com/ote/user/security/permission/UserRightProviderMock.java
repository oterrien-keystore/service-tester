package com.ote.user.security.permission;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("mock-user-right")
@Service
@Slf4j
public class UserRightProviderMock implements IUserRightProvider {

    public UserRightProviderMock() {
        log.warn("###### MOCK ##### " + this.getClass().getSimpleName());
    }

    public boolean doesUserOwnPrivilegeForApplicationOnPerimeter(String user, String application, String perimeter, String privilege) {
        return true;
    }
}
