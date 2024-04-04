package com.orfosys.common.pagination;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import com.orfosys.common.response.Pagination;

public class Paginator {
    public record Pair<T>(Pagination pagination, List<T> results) {
        public Pair {
            pagination = Objects.requireNonNull(pagination);
        }
    }
    
    public static <T, R> Pair<R> create(Page<T> page, Function<T, R> mapper) {
        var content = page.getContent().stream().map(mapper).toList();
        var pageNumber = page.getPageable().getPageNumber();
        var pageSize = page.getPageable().getPageSize();
        var total = page.getTotalElements();
        var pagination = new Pagination(pageNumber, pageSize, total);
        return new Pair<R>(pagination, content);
    }

    public static Sort createSort(String sortBy, String sortOrder) {
        return Sort.by(sortOrder.equalsIgnoreCase("asc") ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy));
    }
}
