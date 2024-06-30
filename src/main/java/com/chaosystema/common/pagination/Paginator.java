package com.chaosystema.common.pagination;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import com.chaosystema.common.response.PaginationResponse;

public class Paginator {
    public record Pair<T>(PaginationResponse pagination, List<T> results) {
        public Pair {
            pagination = Objects.requireNonNull(pagination);
        }
    }
    
    public static <T, R> Pair<R> create(Page<T> page, Function<T, R> mapper) {
        var content = page.getContent().stream().map(mapper).toList();
        var pageNumber = page.getPageable().getPageNumber();
        var pageSize = page.getPageable().getPageSize();
        var total = page.getTotalElements();
        var pagination = new PaginationResponse(pageNumber, pageSize, total);
        return new Pair<R>(pagination, content);
    }
}
