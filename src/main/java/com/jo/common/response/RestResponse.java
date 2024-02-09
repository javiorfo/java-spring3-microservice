package com.jo.common.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class RestResponse {

    @Getter
    @Setter
    private RestResponseHeader header;
}
