package com.orfosys.domain.service;

import com.orfosys.common.annotation.UseCase;
import com.orfosys.domain.model.Dummy;

import lombok.AllArgsConstructor;

import com.orfosys.application.in.FindDummy;
import com.orfosys.application.in.SaveDummy;
import com.orfosys.application.out.FindDummyDB;
import com.orfosys.application.out.SaveDummyDB;

@UseCase
@AllArgsConstructor
public class DummyService implements FindDummy, SaveDummy {

    private final FindDummyDB findDummyDB;
    private final SaveDummyDB saveDummyDB;

    @Override
    public Dummy findById(int id) {
        return this.findDummyDB.findById(id);
    }

    @Override
    public Dummy save(Dummy dummy) {
        return this.saveDummyDB.save(dummy);
    } 
}
