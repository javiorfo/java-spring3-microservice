package com.jo.common.response;

import java.util.List;

public record RestResponseHeader(String trace, List<Error> errors) {
    public record Error(String code, String description){}
}
