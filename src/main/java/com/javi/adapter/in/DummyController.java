package com.javi.adapter.in;

import com.javi.annotation.SwaggerSecurity;
import com.javi.annotation.WebAdapter;
import com.javi.application.in.DummyUseCase;
import com.javi.application.in.request.DummyRequest;
import com.javi.application.in.response.DummyResponse;
import com.javi.domain.model.Dummy;
import com.javi.pagination.Page;
import com.javi.response.RestResponsePagination;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@WebAdapter
@RestController
@AllArgsConstructor
@RequestMapping(value = "/dummy")
@SwaggerSecurity
public class DummyController {

    private final DummyUseCase dummyUseCase;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('CLIENT_ADMIN')")
    public ResponseEntity<DummyResponse> find(@PathVariable("id") int id) {
        return ResponseEntity.ok(new DummyResponse(dummyUseCase.findById(id)));
    }

    @GetMapping
    @PreAuthorize("hasRole('CLIENT_ADMIN')")
    public ResponseEntity<RestResponsePagination<Dummy>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        var pageObj = new Page(page, size, sortBy, sortOrder);
        var pageElements = dummyUseCase.findAll(pageObj);
        var response = new RestResponsePagination<>(pageElements.pagination(), pageElements.results());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    @PreAuthorize("hasRole('CLIENT_ADMIN')")
    public ResponseEntity<DummyResponse> save(@Valid @RequestBody DummyRequest request) {
        var dummy = dummyUseCase.save(new Dummy(request.info()));
        return ResponseEntity.ok(new DummyResponse(dummy));
    }
}
