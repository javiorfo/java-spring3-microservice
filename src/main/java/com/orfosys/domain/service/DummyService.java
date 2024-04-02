package com.orfosys.domain.service;

import com.orfosys.common.annotation.UseCase;
import com.orfosys.common.exception.NotFoundException;
import com.orfosys.domain.model.Dummy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.orfosys.common.pagination.Paginator;
import com.orfosys.application.in.FindDummyUseCase;
import com.orfosys.application.in.SaveDummyUseCase;
import com.orfosys.application.out.FindDummyPersistence;
import com.orfosys.application.out.SaveDummyPersistence;

@UseCase
@AllArgsConstructor
@Slf4j
public class DummyService implements FindDummyUseCase, SaveDummyUseCase {

    private final FindDummyPersistence findDummyPersistence;
    private final SaveDummyPersistence saveDummyPersistence;

    @Override
    public Dummy findById(int id) {
        log.info("Searching dummy by id: {}", id);
        return this.findDummyPersistence.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public Paginator.Pair<Dummy> findAll(int page, int size, String sortBy, String sortOrder) {
        log.info("Searching dummies");
        Pageable pageable = PageRequest.of(page, size, Paginator.createSort(sortBy, sortOrder));
        return findDummyPersistence.findAll(pageable);
    }

    @Override
    public Dummy save(Dummy dummy) {
        log.info("Saving dummy: {}", dummy.toString());
        return this.saveDummyPersistence.save(dummy);
    } 
}
