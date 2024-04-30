package com.orfosys.common.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RestResponsePagination<T> extends RestResponse {
   
    @Getter
    private PaginationResponse pagination;

    @Getter
    private List<T> elements;

}
