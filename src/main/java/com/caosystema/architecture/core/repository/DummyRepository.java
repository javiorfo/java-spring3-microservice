package com.caosystema.architecture.core.repository;

import com.caosystema.architecture.core.dto.DummyDTO;

public interface DummyRepository {
    
    public DummyDTO getDummyById(int id);
}
