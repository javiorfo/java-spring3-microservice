package com.orfosys.adapter.out.mappers;

import com.orfosys.adapter.out.entities.DummyEntity;
import com.orfosys.domain.model.Dummy;

public class DummyMapper {

    public static Dummy entityToDomain(DummyEntity dummyEntity) {
        if (dummyEntity != null) {
            return new Dummy(dummyEntity.getInfo());
        }
        throw new IllegalStateException("DummyEntity is null");
    }

    public static DummyEntity domainToEntity(Dummy dummy) {
        return dummy != null ? new DummyEntity(dummy.info()) : null;
    }
}
