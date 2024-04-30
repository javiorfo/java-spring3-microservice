package com.orfosys.application.in.interfaces;

public interface SaveUseCase<T> {
    public T save(T entity);
}
