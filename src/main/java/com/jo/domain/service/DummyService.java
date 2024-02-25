package com.jo.domain.service;

import com.jo.common.annotation.UseCase;
import com.jo.common.response.Pagination;
import com.jo.domain.model.Dummy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    public ImmutablePair<Pagination, List<Dummy>> findAll(int page, int size, String sortBy, String sortOrder) {
        Sort sort = Sort.by(sortOrder.equalsIgnoreCase("asc") ? Sort.Order.asc(sortBy) : Sort.Order.desc(sortBy));
        Pageable pageable = PageRequest.of(page, size, sort);
        return queryDummy.findAll(pageable);
    }

    @Override
    public Dummy save(Dummy dummy) {
        log.info("Saving dummy: " + dummy.toString());
        return this.saveDummy.save(dummy);
    } 
}
