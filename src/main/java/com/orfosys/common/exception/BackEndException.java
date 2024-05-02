package com.orfosys.common.exception;

import org.springframework.http.HttpStatus;
import com.orfosys.common.response.RestResponseError;

import lombok.Getter;

public class BackEndException extends RuntimeException {
    
    @Getter
    private RestResponseError.Error error;

    public BackEndException(HttpStatus httpStatus, String code, String description) {
        super();
        error = new RestResponseError.Error(httpStatus, code, description);
    }
}
