package com.orfosys.adapter.out;

import com.orfosys.application.out.FindDummy;
import com.orfosys.application.out.SaveDummy;
import com.orfosys.common.annotation.PersistenceAdapter;
import com.orfosys.common.exception.DummyException;
import com.orfosys.domain.model.Dummy;

import lombok.AllArgsConstructor;

@PersistenceAdapter
@AllArgsConstructor
public class DummyPersistenceAdapter implements FindDummy, SaveDummy {
    
    private final DummyEntityRepository dummyEntityRepository;

    @Override
    public Dummy findById(int id) {
        return dummyEntityRepository
                .findById(id)
                .map(DummyMapper::entityToDomain)
                .orElseThrow(DummyException::new);
    }

    @Override
    public Dummy save(Dummy dummy) {
        var dummyEntity = DummyMapper.domainToEntity(dummy);
        dummy = DummyMapper.entityToDomain(dummyEntityRepository.save(dummyEntity));
        return dummy;
    }
}
