package com.orfosys.adapter.out;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import static org.assertj.core.api.Assertions.assertThat;

import com.orfosys.domain.model.Dummy;


@DataJpaTest
@Import({DummyPersistenceAdapter.class, DummyMapper.class})
public class DummyPersistenceTest {
    
    @Autowired
    private DummyPersistenceAdapter dummyPersistenceAdapter;

    @Test
    @Sql("db.sql")
    public void findById() {
        Dummy dummy = dummyPersistenceAdapter.findById(1);

        assertThat(dummy.getInfo()).isEqualTo("dummy 1");
    }

    @Test
    public void save() {
        var dummy = new Dummy("saved");
        dummy = dummyPersistenceAdapter.save(dummy);

        assertThat(dummy.getInfo()).isEqualTo("saved");
    }
}
