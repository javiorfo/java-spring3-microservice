package com.orfosys.common.pagination;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public record Page(int page, int size, String sortBy, String sortOrder) {
    
    public Pageable getPageable() {
        return PageRequest.of(page, size, createSort(sortBy, sortOrder));
    }

    private Sort createSort(String sortBy, String sortOrder) {
        return Sort.by(sortOrder.equalsIgnoreCase("asc") ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy));
    }
}
