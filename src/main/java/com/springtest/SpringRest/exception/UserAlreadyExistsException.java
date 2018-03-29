package com.springtest.SpringRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistsException extends RuntimeException {

    private static final String MESSAGE = " already exists!";

    public UserAlreadyExistsException(Long userId) {
        super(userId + UserAlreadyExistsException.MESSAGE);
    }

    public UserAlreadyExistsException(String username) {
        super(username + UserAlreadyExistsException.MESSAGE);
    }
}