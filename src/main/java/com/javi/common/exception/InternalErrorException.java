package com.javi.common.exception;

import org.springframework.http.HttpStatus;

public class InternalErrorException extends BackEndException {

    public InternalErrorException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_ERROR", "Internal error. Call client support.");
    }
}
