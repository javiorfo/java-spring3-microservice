package com.orfosys.application.in;

import com.orfosys.common.pagination.Paginator;
import com.orfosys.domain.model.Dummy;

public interface FindDummyUseCase {
    public Dummy findById(int id);
    public Paginator.Pair<Dummy> findAll(int page, int size, String sortBy, String sortOrder);
}

