package com.javiorfo.architecture.core.repository;

import com.javiorfo.architecture.core.dto.DummyDTO;

public interface DummyRepository {
    
    public DummyDTO getDummyById(int id);
}
