package com.orfosys.adapter.in;

import com.orfosys.application.in.FindDummy;
import com.orfosys.application.in.SaveDummy;
import com.orfosys.application.in.request.DummyRequest;
import com.orfosys.application.out.response.DummyResponse;
import com.orfosys.common.annotation.WebAdapter;
import com.orfosys.domain.model.Dummy;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@WebAdapter
@RestController
@AllArgsConstructor
@RequestMapping(value = "/dummy")
public class DummyController {
   
    private final FindDummy findDummy;
    private final SaveDummy saveDummy;

    @GetMapping
    public ResponseEntity<DummyResponse> get() {
        return ResponseEntity.ok(new DummyResponse(findDummy.findById(1).getInfo()));
    }

    @PostMapping
    public ResponseEntity<DummyResponse> save(@RequestBody DummyRequest request) {
        var dummy = saveDummy.save(new Dummy(request.info())); 
        return ResponseEntity.ok(new DummyResponse(dummy.getInfo()));
    }
}
