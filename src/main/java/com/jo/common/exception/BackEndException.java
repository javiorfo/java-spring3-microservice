package com.jo.common.exception;

import org.springframework.http.HttpStatus;
import com.jo.common.response.RestResponseHeader;

import lombok.Getter;

public class BackEndException extends RuntimeException {
    
    @Getter
    private RestResponseHeader.Error error;

    public BackEndException(HttpStatus httpStatus, String code, String description) {
        super();
        error = new RestResponseHeader.Error(httpStatus, code, description);
    }
}
