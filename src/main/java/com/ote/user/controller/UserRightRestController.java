package com.ote.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-secured")
public class UserRightRestController {

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasPermission('DEAL/GLE', 'READ_WRITE')")
    public String test(Authentication authentication) {

        return authentication.getName() + " has enough permission";
    }
}
