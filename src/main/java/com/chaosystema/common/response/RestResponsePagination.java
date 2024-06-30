package com.chaosystema.common.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RestResponsePagination<T> {
   
    @Getter
    private PaginationResponse pagination;

    @Getter
    private List<T> elements;

}
