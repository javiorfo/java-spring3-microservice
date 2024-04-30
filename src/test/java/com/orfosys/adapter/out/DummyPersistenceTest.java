package com.orfosys.adapter.out;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.orfosys.adapter.out.mappers.DummyMapper;
import com.orfosys.common.pagination.Page;
import com.orfosys.domain.model.Dummy;

@DataJpaTest(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
@Import({ DummyPersistenceAdapter.class, DummyMapper.class })
public class DummyPersistenceTest {

    @Autowired
    private DummyPersistenceAdapter dummyPersistenceAdapter;

    @TestConfiguration
    @EnableJpaAuditing(auditorAwareRef = "testAuditorAware")
    public static class TestConfig {
        @Bean
        public AuditorAware<String> testAuditorAware() {
            return () -> Optional.ofNullable("TestUser");
        }
    }
    
    @Test
    @Sql("db.sql")
    public void findById() {
        var dummy = dummyPersistenceAdapter.findById(1);
        assertThat(dummy.get().info()).isEqualTo("dummy 1");
    }

    @Test
    @Sql("db.sql")
    public void findAll() {
        var page = new Page(0, 10, "id", "asc");

        var result = dummyPersistenceAdapter.findAll(page);

        assertThat(result.results().size()).isEqualTo(2);
    }

    @Test
    public void save() {
        var dummy = new Dummy("saved");
        dummy = dummyPersistenceAdapter.save(dummy);

        assertThat(dummy.info()).isEqualTo("saved");
    }
}
