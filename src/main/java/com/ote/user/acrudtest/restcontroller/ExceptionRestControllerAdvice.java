package com.ote.user.acrudtest.restcontroller;

import com.ote.crud.exception.NotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ExceptionRestControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Error handle(Throwable e) {
        log.error(e.getMessage(), e);
        return new Error(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> handle(MethodArgumentNotValidException exception) {

        return exception.getBindingResult().getFieldErrors().stream().
                map(p -> p.getObjectName() + ": " + p.getField() + " " + p.getDefaultMessage()).
                collect(Collectors.toList());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handle(NotFoundException e) {
        log.info(e.getMessage(), e);
    }

    @RequiredArgsConstructor
    public static class Error {
        @Getter
        private final String message;
    }

}
