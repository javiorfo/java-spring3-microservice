package com.orfosys.application.out.interfaces;

import com.orfosys.common.pagination.Paginator;
import com.orfosys.common.pagination.Page;

public interface FindAllPersistence<T> {
    public Paginator.Pair<T> findAll(Page page);
}
