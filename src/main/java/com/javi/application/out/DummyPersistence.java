package com.javi.application.out;

import com.javi.domain.model.Dummy;

public interface DummyPersistence extends FindByIdPersistence<Dummy>, FindAllPersistence<Dummy>, SavePersistence<Dummy> {
}
