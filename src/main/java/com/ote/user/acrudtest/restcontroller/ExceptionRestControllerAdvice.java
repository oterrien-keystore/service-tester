package com.ote.user.acrudtest.restcontroller;

import com.ote.crud.IExceptionRestControllerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionRestControllerAdvice implements IExceptionRestControllerAdvice {

    @Override
    public Logger getLogger() {
        return log;
    }
}
