package com.orfosys.common.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.orfosys.common.response.RestResponseError;

import lombok.Getter;

public class BackEndListException extends RuntimeException {
    
    @Getter
    private List<RestResponseError.Error> errors;

    @Getter
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public BackEndListException(HttpStatus httpStatus, List<RestResponseError.Error> errors) {
        super();
        this.errors = errors;
        this.httpStatus = httpStatus;
    }
}
