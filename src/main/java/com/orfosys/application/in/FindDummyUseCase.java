package com.orfosys.application.in;

import com.orfosys.common.pagination.Page;
import com.orfosys.common.pagination.Paginator;
import com.orfosys.domain.model.Dummy;

public interface FindDummyUseCase {
    public Dummy findById(int id);
    public Paginator.Pair<Dummy> findAll(Page page);
}

