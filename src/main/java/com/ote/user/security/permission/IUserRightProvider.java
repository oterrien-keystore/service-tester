package com.ote.user.security.permission;

public interface IUserRightProvider {

    boolean doesUserOwnPrivilegeForApplicationOnPerimeter(String user, String application, String perimeter, String privilege);
}
