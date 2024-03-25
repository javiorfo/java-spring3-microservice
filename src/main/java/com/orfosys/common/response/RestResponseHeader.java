package com.orfosys.common.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record RestResponseHeader(String trace, List<Error> errors) {
    public record Error(@JsonIgnore HttpStatus httpStatus, String code, String description){}
}
