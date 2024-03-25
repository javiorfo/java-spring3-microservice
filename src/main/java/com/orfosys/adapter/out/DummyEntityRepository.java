package com.orfosys.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface DummyEntityRepository extends RevisionRepository<DummyEntity, Integer, Integer>, JpaRepository<DummyEntity, Integer> {
}
