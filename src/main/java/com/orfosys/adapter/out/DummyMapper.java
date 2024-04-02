package com.orfosys.adapter.out;

import java.util.Optional;

import com.orfosys.domain.model.Dummy;

public class DummyMapper {

    public static Dummy entityToDomain(DummyEntity dummyEntity) {
        if (dummyEntity != null) {
            return new Dummy(dummyEntity.getInfo());
        }
        throw new IllegalStateException("DummyEntity is null");
    }

    public static Optional<DummyEntity> domainToEntity(Dummy dummy) {
        return dummy != null ? Optional.of(new DummyEntity(dummy.info())) : Optional.empty();
    }
}
