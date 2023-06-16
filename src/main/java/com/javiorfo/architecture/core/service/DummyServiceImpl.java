package com.javiorfo.architecture.core.service;

import org.springframework.stereotype.Service;
import com.javiorfo.architecture.core.dto.DummyDTO;
import com.javiorfo.architecture.core.repository.DummyRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DummyServiceImpl implements DummyService { 

    @Autowired
    private DummyRepository dummyRepository;

    @Override
    public DummyDTO getDummyById(int id) {
        return dummyRepository.getDummyById(id);
    }
}
