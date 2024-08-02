package com.javi.adapter.in;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

import com.javi.application.in.DummyUseCase;
import com.javi.domain.model.Dummy;
import com.javi.pagination.Page;
import com.javi.pagination.Paginator;
import com.javi.response.PaginationResponse;

@WebMvcTest(controllers = DummyController.class)
@AutoConfigureMockMvc(addFilters = false)
@DisabledInAotMode
public class DummyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DummyUseCase dummyUseCase;

    @Test
    void find() throws Exception {
        Mockito.when(dummyUseCase.findById(1)).thenReturn(new Dummy("dummy"));

        mockMvc.perform(get("/dummy/{id}", 1)
                .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void findAll() throws Exception {
        var page = new Page(0, 10, "id", "asc");
        var pair = new Paginator.Pair<Dummy>(new PaginationResponse(0, 10, 0), Collections.emptyList());

        Mockito.when(dummyUseCase.findAll(page)).thenReturn(pair);

        mockMvc.perform(get("/dummy")
                .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void save() throws Exception {
        var dummy = new Dummy("dummy");
        Mockito.when(dummyUseCase.save(dummy)).thenReturn(dummy);

        var json = """
                {
                    "info": "papa"
                }
        """;

        mockMvc.perform(post("/dummy")
                .header("Content-Type", "application/json")
                .content(json))
                .andExpect(status().isOk());
    }
}
