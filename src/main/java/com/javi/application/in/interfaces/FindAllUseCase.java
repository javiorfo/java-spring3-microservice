package com.javi.application.in.interfaces;

import com.javi.common.pagination.Page;
import com.javi.common.pagination.Paginator;

public interface FindAllUseCase<T> {
    public Paginator.Pair<T> findAll(Page page);
}

