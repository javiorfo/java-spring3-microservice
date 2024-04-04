package com.orfosys.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class RestResponse {

    @Getter
    @Setter
    @JsonInclude(Include.NON_NULL)
    private RestResponseHeader header;
}
