package com.jo.adapter.out.utils;

import java.util.List;
import java.util.function.Function;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.data.domain.Page;

import com.jo.common.response.Pagination;

public class Paginator {
    public static <T, R> ImmutablePair<Pagination, List<R>> create(Page<T> page, Function<T, R> mapper) {
        var content = page.getContent().stream().map(mapper).toList();
        var pageNumber = page.getPageable().getPageNumber();
        var pageSize = page.getPageable().getPageSize();
        var total = page.getTotalElements();
        var pagination = new Pagination(pageNumber, pageSize, total);
        return new ImmutablePair<>(pagination, content); 
    }
}
