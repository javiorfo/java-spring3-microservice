package com.chaosystema.application.in.interfaces;

import com.chaosystema.common.pagination.Page;
import com.chaosystema.common.pagination.Paginator;

public interface FindAllUseCase<T> {
    public Paginator.Pair<T> findAll(Page page);
}

