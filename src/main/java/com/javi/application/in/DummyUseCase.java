package com.javi.application.in;

import com.javi.domain.model.Dummy;

public interface DummyUseCase extends FindByIdUseCase<Dummy>, FindAllUseCase<Dummy>, SaveUseCase<Dummy> {
}
