package com.javi.adapter.out;

import java.util.Optional;

import com.javi.common.pagination.Page;
import com.javi.common.pagination.Paginator;
import com.javi.application.out.DummyPersistence;
import com.javi.common.annotation.PersistenceAdapter;
import com.javi.domain.model.Dummy;

import com.javi.adapter.out.repositories.DummyEntityRepository;
import com.javi.adapter.out.mappers.DummyMapper;

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
