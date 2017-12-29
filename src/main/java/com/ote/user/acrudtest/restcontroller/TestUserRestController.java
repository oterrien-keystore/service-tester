package com.ote.user.acrudtest.restcontroller;

import com.ote.crud.exception.CreateException;
import com.ote.crud.exception.MergeException;
import com.ote.crud.exception.NotFoundException;
import com.ote.crud.exception.ResetException;
import com.ote.crud.model.Filters;
import com.ote.crud.model.SortingParameters;
import com.ote.crud.model.SplitList;
import com.ote.crud.model.SplitListParameter;
import com.ote.user.acrudtest.persistence.TestUserPersistenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/testUser")
@Slf4j
public class TestUserRestController {

    @Autowired
    private TestUserPersistenceService testUserPersistenceService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TestUserPayload get(@PathVariable("id") int id) throws NotFoundException {
        log.info("get user where id " + id);
        return testUserPersistenceService.findOne(id).orElseThrow(() -> new NotFoundException("TestUser", id));
    }

    /*
    http://localhost:7979/api/v1/testUser?filters='[{"property":"login", "value":"olivier","operation":"EQUALS"}]'&splitParam='{"pageSize"=20,"pageIndex="0"}'&sortingParams='[{"property":"login","direction":"ASC"}]'
     */
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public SplitList<TestUserPayload> get(@RequestParam(name = "filters", required = false) Filters filters,
                                          @RequestParam(name = "sortingParameters", required = false) SortingParameters sortingParameters,
                                          @RequestParam(name = "splitParameters", required = false) SplitListParameter splitListParam) {
        log.info("get many users");
        return testUserPersistenceService.findMany(filters, sortingParameters, splitListParam);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TestUserPayload reset(@PathVariable("id") int id, @RequestBody TestUserPayload user) throws ResetException, NotFoundException {
        log.info("reset user where id " + id);
        return testUserPersistenceService.reset(id, user).orElseThrow(() -> new NotFoundException("TestUser", id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TestUserPayload merge(@PathVariable("id") int id, @RequestBody TestUserPayload user) throws MergeException, NotFoundException {
        log.info("merge user where id " + id);
        return testUserPersistenceService.merge(id, user).orElseThrow(() -> new NotFoundException("TestUser", id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public TestUserPayload create(@RequestBody TestUserPayload user) throws CreateException {
        log.info("create user");
        return testUserPersistenceService.create(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        log.info("delete user where id " + id);
        testUserPersistenceService.deleteOne(id);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam(name = "filters", required = false) Filters filters) {
        log.info("delete many users");
        testUserPersistenceService.deleteMany(filters);
    }
}
