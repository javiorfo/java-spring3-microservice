package com.chaosystema.application.out.interfaces;

import com.chaosystema.common.pagination.Paginator;
import com.chaosystema.common.pagination.Page;

public interface FindAllPersistence<T> {
    public Paginator.Pair<T> findAll(Page page);
}
