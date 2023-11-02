package com.jo.adapter.out;

import com.jo.domain.model.Dummy;

public class DummyMapper {

    public static Dummy entityToDomain(DummyEntity dummyEntity) {
        return new Dummy(dummyEntity.getInfo());
    }

    public static DummyEntity domainToEntity(Dummy dummy) {
        return new DummyEntity(dummy.getInfo());
    }
}
