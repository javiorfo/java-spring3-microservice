package com.orfosys.domain.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.orfosys.application.out.DummyPersistence;
import com.orfosys.domain.model.Dummy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

public class DummyServiceTest {

    private final DummyPersistence dummyPersistence = Mockito.mock(DummyPersistence.class);
    private final DummyService dummyService = new DummyService(dummyPersistence);

    @Test
    public void findDummy() {
        Dummy dummy = Mockito.mock(Dummy.class);
        given(dummy.info()).willReturn("test");

        given(dummyPersistence.findById(eq(1))).willReturn(Optional.of(dummy));

        dummy = dummyService.findById(1);

        assertThat(dummy).isNotNull();
    }

    @Test
    public void saveDummy() {
        Dummy dummy = Mockito.mock(Dummy.class);
        given(dummy.info()).willReturn("save");

        given(dummyPersistence.save(eq(dummy))).willReturn(dummy);

        dummy = dummyService.save(dummy);

        assertThat(dummy.info()).isEqualTo("save");
    }
}
