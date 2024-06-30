package com.chaosystema.adapter.out.mappers;

import com.chaosystema.adapter.out.entities.DummyEntity;
import com.chaosystema.domain.model.Dummy;

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
