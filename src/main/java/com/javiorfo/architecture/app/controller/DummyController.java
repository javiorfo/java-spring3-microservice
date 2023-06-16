package com.javiorfo.architecture.app.controller;

import com.javiorfo.architecture.app.response.DummyResponse;
import com.javiorfo.architecture.core.service.DummyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/dummy")
public class DummyController {
    
    @Autowired
    private DummyService dummyService;
   
    @GetMapping
    public ResponseEntity<DummyResponse> getAccount() {
        return ResponseEntity.ok(new DummyResponse(dummyService.getDummyById(1).info()));
    }
}
