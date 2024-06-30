package com.chaosystema.adapter.out;

import java.util.Optional;

import com.chaosystema.common.pagination.Page;
import com.chaosystema.common.pagination.Paginator;
import com.chaosystema.application.out.DummyPersistence;
import com.chaosystema.common.annotation.PersistenceAdapter;
import com.chaosystema.domain.model.Dummy;

import com.chaosystema.adapter.out.repositories.DummyEntityRepository;
import com.chaosystema.adapter.out.mappers.DummyMapper;

import lombok.AllArgsConstructor;

@PersistenceAdapter
@AllArgsConstructor
public class DummyPersistenceAdapter implements DummyPersistence {

    private final DummyEntityRepository dummyEntityRepository;

    @Override
    public Optional<Dummy> findById(int id) {
        return dummyEntityRepository
                .findById(id)
                .map(DummyMapper::entityToDomain);
    }

    @Override
    public Dummy save(Dummy dummy) {
        var dummyEntity = DummyMapper.domainToEntity(dummy);
        dummy = DummyMapper.entityToDomain(dummyEntityRepository.save(dummyEntity));
        return dummy;
    }

    @Override
    public Paginator.Pair<Dummy> findAll(Page page) {
        return Paginator.create(dummyEntityRepository.findAll(page.getPageable()), DummyMapper::entityToDomain);
    }
}
