package com.orfosys.domain.service;

import com.orfosys.common.annotation.UseCase;
import com.orfosys.domain.model.Dummy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.orfosys.application.in.FindDummyUseCase;
import com.orfosys.application.in.SaveDummyUseCase;
import com.orfosys.application.out.FindDummy;
import com.orfosys.application.out.SaveDummy;

@UseCase
@AllArgsConstructor
@Slf4j
public class DummyService implements FindDummyUseCase, SaveDummyUseCase {

    private final FindDummy findDummyDB;
    private final SaveDummy saveDummyDB;

    @Override
    public Dummy findById(int id) {
        log.info("Searching dummy by id: " + id);
        return this.findDummyDB.findById(id);
    }

    @Override
    public Dummy save(Dummy dummy) {
        log.info("Saving dummy: " + dummy);
        return this.saveDummyDB.save(dummy);
    } 
}
