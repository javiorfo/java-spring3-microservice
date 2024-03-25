package com.orfosys.common.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.orfosys.common.response.RestResponseHeader;

import lombok.Getter;

public class BackEndListException extends RuntimeException {
    
    @Getter
    private List<RestResponseHeader.Error> errors;

    @Getter
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public BackEndListException(HttpStatus httpStatus, List<RestResponseHeader.Error> errors) {
        super();
        this.errors = errors;
        this.httpStatus = httpStatus;
    }
}
