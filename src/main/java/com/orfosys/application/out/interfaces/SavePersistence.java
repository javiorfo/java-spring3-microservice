package com.orfosys.application.out.interfaces;

public interface SavePersistence<T> {
    public T save(T entity);
}
