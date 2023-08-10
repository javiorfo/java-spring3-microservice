package com.orfosys.adapter.in;

import com.orfosys.application.in.FindDummy;
import com.orfosys.application.out.response.DummyResponse;
import com.orfosys.common.annotation.WebAdapter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@WebAdapter
@RestController
@RequestMapping(value = "/dummy")
public class DummyController {
   
    private final FindDummy findDummy;

    public DummyController(FindDummy findDummy) {
        this.findDummy = findDummy;
    }
   
    @GetMapping
    public ResponseEntity<DummyResponse> getAccount() {
        return ResponseEntity.ok(new DummyResponse(findDummy.findById(1).getInfo()));
    }
}
