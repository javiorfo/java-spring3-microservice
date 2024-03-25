package com.orfosys.application.out;

import org.springframework.data.domain.Pageable;

import com.orfosys.common.pagination.Paginator;
import com.orfosys.domain.model.Dummy;

public interface QueryDummy {
    public Dummy findById(int id);
    public Paginator.Pair<Dummy> findAll(Pageable pageable);
}
