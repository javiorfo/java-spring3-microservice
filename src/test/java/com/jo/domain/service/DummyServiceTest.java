package com.jo.domain.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.jo.application.out.QueryDummy;
import com.jo.application.out.SaveDummy;
import com.jo.domain.model.Dummy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;

public class DummyServiceTest {
    
    private final QueryDummy queryDummy= Mockito.mock(QueryDummy.class);
    private final SaveDummy saveDummy= Mockito.mock(SaveDummy.class);
    private final DummyService dummyService = new DummyService(queryDummy, saveDummy);

    @Test
    public void findDummy() {
        Dummy dummy = Mockito.mock(Dummy.class);
		given(dummy.info())
				.willReturn("test");

		given(queryDummy.findById(eq(1)))
				.willReturn(dummy);

        dummy = dummyService.findById(1);

        assertThat(dummy).isNotNull();
    }

    @Test
    public void saveDummy() {
        Dummy dummy = Mockito.mock(Dummy.class);
		given(dummy.info())
				.willReturn("save");

		given(saveDummy.save(eq(dummy)))
				.willReturn(dummy);

        dummy = dummyService.save(dummy);

        assertThat(dummy.info()).isEqualTo("save");
    }
}
