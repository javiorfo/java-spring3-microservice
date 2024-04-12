package com.orfosys.application.out;

import java.util.Optional;

import com.orfosys.common.pagination.Page;
import com.orfosys.common.pagination.Paginator;
import com.orfosys.domain.model.Dummy;

public interface FindDummyPersistence {
    public Optional<Dummy> findById(int id);
    public Paginator.Pair<Dummy> findAll(Page page);
}
