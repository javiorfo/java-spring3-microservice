package com.orfosys.application.out;

import com.orfosys.application.out.interfaces.FindAllPersistence;
import com.orfosys.application.out.interfaces.FindByIdPersistence;
import com.orfosys.application.out.interfaces.SavePersistence;
import com.orfosys.domain.model.Dummy;

public interface DummyPersistence extends FindByIdPersistence<Dummy>, FindAllPersistence<Dummy>, SavePersistence<Dummy> {
}
