package com.orfosys.adapter.out;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.orfosys.domain.model.Dummy;

@DataJpaTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
@Import({ DummyPersistenceAdapter.class, DummyMapper.class })
public class DummyPersistenceTest {

    @TestConfiguration
    @EnableJpaAuditing(auditorAwareRef = "testAuditorAware")
    public static class TestConfig {
        @Bean
        public AuditorAware<String> testAuditorAware() {
            return () -> Optional.ofNullable("TestUser");
        }
    }

    @Autowired
    private DummyPersistenceAdapter dummyPersistenceAdapter;

    @Test
    @Sql("db.sql")
    public void findById() {
        var dummy = dummyPersistenceAdapter.findById(1);
        assertThat(dummy.get().info()).isEqualTo("dummy 1");
    }

    @Test
    @Sql("db.sql")
    public void findAll() {
        var pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.asc("id")));

        var result = dummyPersistenceAdapter.findAll(pageable);

        assertThat(result.results().size()).isEqualTo(2);
    }

    @Test
    public void save() {
        var dummy = new Dummy("saved");
        dummy = dummyPersistenceAdapter.save(dummy);

        assertThat(dummy.info()).isEqualTo("saved");
    }
}
