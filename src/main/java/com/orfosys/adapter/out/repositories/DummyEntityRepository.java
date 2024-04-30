package com.orfosys.adapter.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orfosys.adapter.out.entities.DummyEntity;

public interface DummyEntityRepository extends JpaRepository<DummyEntity, Integer> {
}
