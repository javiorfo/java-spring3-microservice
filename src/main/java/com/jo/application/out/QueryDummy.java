package com.jo.application.out;

import org.springframework.data.domain.Pageable;

import com.jo.common.pagination.Paginator;
import com.jo.domain.model.Dummy;

public interface QueryDummy {
    public Dummy findById(int id);
    public Paginator.Pair<Dummy> findAll(Pageable pageable);
}
