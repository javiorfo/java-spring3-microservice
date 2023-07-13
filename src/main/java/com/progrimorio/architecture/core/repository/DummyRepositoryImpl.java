package com.caosystema.architecture.core.repository;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.caosystema.architecture.core.dto.DummyDTO;

@Repository
public class DummyRepositoryImpl implements DummyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public DummyDTO getDummyById(int id) {
        var query = "select info from dummy where id = 1";
        return new DummyDTO(jdbcTemplate.queryForObject(query, String.class));
    }
}
