package com.jo.application.out;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.data.domain.Pageable;

import com.jo.common.response.Pagination;
import com.jo.domain.model.Dummy;

public interface QueryDummy {
    public Dummy findById(int id);
    public ImmutablePair<Pagination, List<Dummy>> findAll(Pageable pageable);
}
