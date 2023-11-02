package com.jo.domain.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.jo.application.out.FindDummy;
import com.jo.application.out.SaveDummy;
import com.jo.domain.model.Dummy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

public class DummyServiceTest {
    
    private final FindDummy findDummyDB = Mockito.mock(FindDummy.class);
    private final SaveDummy saveDummyDB = Mockito.mock(SaveDummy.class);
    private final DummyService dummyService = new DummyService(findDummyDB, saveDummyDB);

    @Test
    public void findDummy() {
        Dummy dummy = Mockito.mock(Dummy.class);
		given(dummy.getInfo())
				.willReturn("test");

		given(findDummyDB.findById(eq(1)))
				.willReturn(dummy);

        dummy = dummyService.findById(1);

        assertThat(dummy).isNotNull();
    }

    @Test
    public void saveDummy() {
        Dummy dummy = Mockito.mock(Dummy.class);
		given(dummy.getInfo())
				.willReturn("save");

		given(saveDummyDB.save(eq(dummy)))
				.willReturn(dummy);

        dummy = dummyService.save(dummy);

        assertThat(dummy.getInfo()).isEqualTo("save");
    }
}
