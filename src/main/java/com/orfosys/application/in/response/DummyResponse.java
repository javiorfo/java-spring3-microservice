package com.orfosys.application.in.response;

import com.orfosys.common.response.RestResponse;
import com.orfosys.domain.model.Dummy;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class DummyResponse extends RestResponse {

    @Getter
    private Dummy dummy;
}
