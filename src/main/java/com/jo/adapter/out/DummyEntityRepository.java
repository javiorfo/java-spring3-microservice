package com.jo.adapter.out;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface DummyEntityRepository extends RevisionRepository<DummyEntity, Integer, Integer>, PagingAndSortingRepository<DummyEntity, Integer>, CrudRepository<DummyEntity, Integer> {
}
