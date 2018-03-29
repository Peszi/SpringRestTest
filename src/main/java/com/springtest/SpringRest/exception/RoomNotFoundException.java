package com.springtest.SpringRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(Long roomId) {
        super("could not found room with ID: " + roomId);
    }
}
