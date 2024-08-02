package com.javi.common.exception;

import org.springframework.http.HttpStatus;

import com.javi.exception.BackEndException;

public class NotFoundException extends BackEndException {

    public NotFoundException() {
        super(HttpStatus.NOT_FOUND, "NOT_FOUND", "Entity not found!");
    }

    public NotFoundException(HttpStatus httpStatus, String code, String description) {
        super(httpStatus, code, description);
    }
}
