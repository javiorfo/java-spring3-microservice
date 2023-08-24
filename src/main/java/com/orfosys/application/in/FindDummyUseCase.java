package com.orfosys.application.in;

import com.orfosys.domain.model.Dummy;

public interface FindDummyUseCase {
    public Dummy findById(int id);
}

