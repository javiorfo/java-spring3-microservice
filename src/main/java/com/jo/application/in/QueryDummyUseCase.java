package com.jo.application.in;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;

import com.jo.common.response.Pagination;
import com.jo.domain.model.Dummy;

public interface QueryDummyUseCase {
    public Dummy findById(int id);
    public ImmutablePair<Pagination, List<Dummy>> findAll(int page, int size, String sortBy, String sortOrder);
}

