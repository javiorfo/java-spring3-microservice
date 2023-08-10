package com.orfosys.domain.service;

import com.orfosys.common.annotation.UseCase;
import com.orfosys.domain.model.Dummy;
import com.orfosys.application.in.FindDummy;
import com.orfosys.application.out.FindDummyById;

@UseCase
public class DummyService implements FindDummy {

    private final FindDummyById findDummyById;

    public DummyService(FindDummyById findDummyById) {
        this.findDummyById = findDummyById;
    }

    @Override
    public Dummy findById(int id) {
        return this.findDummyById.findById(id);
    } 
}
