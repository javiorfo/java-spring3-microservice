package com.javi.application.out.interfaces;

import com.javi.common.pagination.Paginator;
import com.javi.common.pagination.Page;

public interface FindAllPersistence<T> {
    public Paginator.Pair<T> findAll(Page page);
}
