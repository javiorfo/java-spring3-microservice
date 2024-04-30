package com.orfosys.application.in.interfaces;

import com.orfosys.common.pagination.Page;
import com.orfosys.common.pagination.Paginator;

public interface FindAllUseCase<T> {
    public Paginator.Pair<T> findAll(Page page);
}

