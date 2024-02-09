package com.jo.application.in.response;

import com.jo.common.response.RestResponse;
import com.jo.domain.model.Dummy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DummyResponse extends RestResponse {

    @Getter
    private Dummy dummy;
}
