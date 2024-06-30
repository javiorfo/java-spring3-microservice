package com.chaosystema.application.in;

import com.chaosystema.application.in.interfaces.FindAllUseCase;
import com.chaosystema.application.in.interfaces.FindByIdUseCase;
import com.chaosystema.application.in.interfaces.SaveUseCase;
import com.chaosystema.domain.model.Dummy;

public interface DummyUseCase extends FindByIdUseCase<Dummy>, FindAllUseCase<Dummy>, SaveUseCase<Dummy> {
}
