package com.chaosystema.application.out.interfaces;

import java.util.Optional;

public interface FindByIdPersistence<T> {
    public Optional<T> findById(int id);
}
