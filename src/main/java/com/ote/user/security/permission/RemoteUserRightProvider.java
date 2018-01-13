package com.ote.user.security.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Profile("!mock-user-right")
@Service
public class RemoteUserRightProvider implements IUserRightProvider {

    @Value("${user-service.url}")
    private String userServiceUrl;

    @Value("${user-service.endpoints.rights}")
    private String userServiceRightsEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    public boolean doesUserOwnPrivilegeForApplicationOnPerimeter(String user, String application, String perimeter, String privilege) {

        String url = UriComponentsBuilder.
                fromHttpUrl(userServiceUrl).
                path(userServiceRightsEndpoint).
                queryParam("user", user).
                queryParam("application", application).
                queryParam("perimeter", perimeter).
                queryParam("privilege", privilege).
                build().
                encode().
                toUriString();

        return restTemplate.getForObject(url, Boolean.class);
    }
}
