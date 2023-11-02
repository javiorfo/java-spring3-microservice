package com.jo.adapter.out;

import com.jo.application.out.FindDummy;
import com.jo.application.out.SaveDummy;
import com.jo.common.annotation.PersistenceAdapter;
import com.jo.common.exception.DummyException;
import com.jo.domain.model.Dummy;

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
