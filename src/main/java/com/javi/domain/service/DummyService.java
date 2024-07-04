package com.javi.domain.service;

import com.javi.common.annotation.UseCase;
import com.javi.common.exception.NotFoundException;
import com.javi.domain.model.Dummy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.javi.common.pagination.Page;
import com.javi.common.pagination.Paginator;
import com.javi.application.in.DummyUseCase;
import com.javi.application.out.DummyPersistence;

@UseCase
@AllArgsConstructor
@Slf4j
public class DummyService implements DummyUseCase {

    private final DummyPersistence dummyPersistence;

    @Override
    public Dummy findById(int id) {
        log.info("Searching dummy by id: {}", id);
        return this.dummyPersistence.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Paginator.Pair<Dummy> findAll(Page page) {
        log.info("Searching dummies");
        return dummyPersistence.findAll(page);
    }

    @Override
    public Dummy save(Dummy dummy) {
        log.info("Saving dummy: {}", dummy.toString());
        return this.dummyPersistence.save(dummy);
    }
}
