package com.orfosys.adapter.out;

import com.orfosys.application.out.FindDummyById;
import com.orfosys.common.annotation.PersistenceAdapter;
import com.orfosys.common.exception.DummyException;
import com.orfosys.domain.model.Dummy;

@PersistenceAdapter
public class DummyPersistenceAdapter implements FindDummyById {
    
    private final DummyEntityRepository dummyEntityRepository;

    public DummyPersistenceAdapter(DummyEntityRepository dummyEntityRepository) {
        this.dummyEntityRepository = dummyEntityRepository;
    }

    @Override
    public Dummy findById(int id) {
        return dummyEntityRepository
                .findById(id)
                .map(DummyMapper::entityToDomain)
                .orElseThrow(DummyException::new);
    }
}
