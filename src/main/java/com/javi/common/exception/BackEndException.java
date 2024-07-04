package com.javi.common.exception;

import org.springframework.http.HttpStatus;
import com.javi.common.response.RestResponseError;

import lombok.Getter;

public class BackEndException extends RuntimeException {
    
    @Getter
    private RestResponseError.Error error;

    public BackEndException(HttpStatus httpStatus, String code, String description) {
        super();
        error = new RestResponseError.Error(httpStatus, code, description);
    }
}
