package com.chaosystema.common.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record RestResponseError(List<Error> errors) {
    public record Error(@JsonIgnore HttpStatus httpStatus, String code, String description){}
}
