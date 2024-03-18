package com.jo.application.in;

import com.jo.common.pagination.Paginator;
import com.jo.domain.model.Dummy;

public interface QueryDummyUseCase {
    public Dummy findById(int id);
    public Paginator.Pair<Dummy> findAll(int page, int size, String sortBy, String sortOrder);
}

