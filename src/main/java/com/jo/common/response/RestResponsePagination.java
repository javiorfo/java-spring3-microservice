package com.jo.common.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RestResponsePagination<T> extends RestResponse {
   
    @Getter
    private Pagination pagination;

    @Getter
    private List<T> elements;

}
