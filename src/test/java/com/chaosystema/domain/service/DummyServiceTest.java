package com.chaosystema.domain.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.chaosystema.application.out.DummyPersistence;
import com.chaosystema.common.pagination.Page;
import com.chaosystema.common.pagination.Paginator;
import com.chaosystema.common.response.PaginationResponse;
import com.chaosystema.domain.model.Dummy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

import java.util.Collections;
import java.util.Optional;

public class DummyServiceTest {

    private final DummyPersistence dummyPersistence = Mockito.mock(DummyPersistence.class);
    private final DummyService dummyService = new DummyService(dummyPersistence);

    @Test
    public void find() {
        Dummy dummy = Mockito.mock(Dummy.class);
        given(dummy.info()).willReturn("test");

        given(dummyPersistence.findById(eq(1))).willReturn(Optional.of(dummy));

        dummy = dummyService.findById(1);

        assertThat(dummy).isNotNull();
    }

    @Test
    public void findAll() {
        var page = new Page(0, 10, "id", "asc");
        var pair = new Paginator.Pair<Dummy>(new PaginationResponse(0, 10, 0), Collections.emptyList());

        given(dummyPersistence.findAll(page)).willReturn(pair);

        var res = dummyService.findAll(page);

        assertThat(res).isNotNull();
    }
    @Test
    public void save() {
        Dummy dummy = Mockito.mock(Dummy.class);
        given(dummy.info()).willReturn("save");

        given(dummyPersistence.save(eq(dummy))).willReturn(dummy);

        dummy = dummyService.save(dummy);

        assertThat(dummy.info()).isEqualTo("save");
    }
}
