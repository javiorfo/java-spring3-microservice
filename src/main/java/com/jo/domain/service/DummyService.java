package com.jo.domain.service;

import com.jo.common.annotation.UseCase;
import com.jo.domain.model.Dummy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.jo.application.in.FindDummyUseCase;
import com.jo.application.in.SaveDummyUseCase;
import com.jo.application.out.FindDummy;
import com.jo.application.out.SaveDummy;

@UseCase
@AllArgsConstructor
@Slf4j
public class DummyService implements FindDummyUseCase, SaveDummyUseCase {

    private final FindDummy findDummy;
    private final SaveDummy saveDummy;

    @Override
    public Dummy findById(int id) {
        log.info("Searching dummy by id: " + id);
        return this.findDummy.findById(id);
    }

    @Override
    public Dummy save(Dummy dummy) {
        log.info("Saving dummy: " + dummy);
        return this.saveDummy.save(dummy);
    } 
}
