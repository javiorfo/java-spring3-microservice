package com.chaosystema.adapter.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaosystema.adapter.out.entities.DummyEntity;

public interface DummyEntityRepository extends JpaRepository<DummyEntity, Integer> {
}
