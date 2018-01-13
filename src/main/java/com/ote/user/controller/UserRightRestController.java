package com.ote.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-secured")
public class UserRightRestController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasPermission('DEAL/GLE', 'READ')")
    public String testGet(Authentication authentication) {

        return authentication.getName() + " own enough permission on application " + applicationName + " to execute this endpoint";
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasPermission('DEAL/GLE', 'WRITE')")
    public String testPost(Authentication authentication) {

        return authentication.getName() + " own enough permission on application " + applicationName + " to execute this endpoint";
    }
}
