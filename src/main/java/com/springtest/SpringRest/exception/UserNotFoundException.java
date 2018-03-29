package com.springtest.SpringRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	private static final String MESSAGE = "could not find user ";

	public UserNotFoundException(Long userId) {
		super(MESSAGE + "with ID: " + userId);
	}

	public UserNotFoundException(String username) {
		super(MESSAGE + username);
	}
}