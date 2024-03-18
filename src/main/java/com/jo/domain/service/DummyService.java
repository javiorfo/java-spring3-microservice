package com.jo.domain.service;

import com.jo.common.annotation.UseCase;
import com.jo.domain.model.Dummy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.jo.common.pagination.Paginator;
import com.jo.application.in.QueryDummyUseCase;
import com.jo.application.in.SaveDummyUseCase;
import com.jo.application.out.QueryDummy;
import com.jo.application.out.SaveDummy;

@UseCase
@AllArgsConstructor
@Slf4j
public class DummyService implements QueryDummyUseCase, SaveDummyUseCase {

    private final QueryDummy queryDummy;
    private final SaveDummy saveDummy;

    @Override
    public Dummy findById(int id) {
        log.info("Searching dummy by id: " + id);
        return this.queryDummy.findById(id);
    }

    @Override
    public Paginator.Pair<Dummy> findAll(int page, int size, String sortBy, String sortOrder) {
        log.info("Searching dummies");
        Pageable pageable = PageRequest.of(page, size, Paginator.createSort(sortBy, sortOrder));
        return queryDummy.findAll(pageable);
    }

    @Override
    public Dummy save(Dummy dummy) {
        log.info("Saving dummy: " + dummy.toString());
        return this.saveDummy.save(dummy);
    } 
}
