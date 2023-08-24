package com.orfosys.adapter.in;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.orfosys.application.in.FindDummyUseCase;
import com.orfosys.application.in.SaveDummyUseCase;

@WebMvcTest(controllers = DummyController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class DummyControllerTest {
    
    @Autowired
	private MockMvc mockMvc;

	@MockBean
	private  FindDummyUseCase findDummyUseCase;
	
    @MockBean
	private  SaveDummyUseCase saveDummyUseCase;

	@Test
	void findDummy() throws Exception {

/* 		mockMvc.perform(get("/orfosys/dummy/{id}", 1)
				.header("Content-Type", "application/json"))
				.andExpect(status().isOk());

		then(findDummyUseCase).should().findById(eq(1)); */
	}
}
