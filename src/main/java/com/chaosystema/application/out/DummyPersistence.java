package com.chaosystema.application.out;

import com.chaosystema.application.out.interfaces.FindAllPersistence;
import com.chaosystema.application.out.interfaces.FindByIdPersistence;
import com.chaosystema.application.out.interfaces.SavePersistence;
import com.chaosystema.domain.model.Dummy;

public interface DummyPersistence extends FindByIdPersistence<Dummy>, FindAllPersistence<Dummy>, SavePersistence<Dummy> {
}
