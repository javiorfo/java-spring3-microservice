package com.javi.application.out;

import com.javi.application.out.interfaces.FindAllPersistence;
import com.javi.application.out.interfaces.FindByIdPersistence;
import com.javi.application.out.interfaces.SavePersistence;
import com.javi.domain.model.Dummy;

public interface DummyPersistence extends FindByIdPersistence<Dummy>, FindAllPersistence<Dummy>, SavePersistence<Dummy> {
}
