package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.services.FaseDeEnsinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fase-de-ensino")
public class FaseDeEnsinoRestController {

    @Autowired
    FaseDeEnsinoService faseDeEnsinoService;

    @GetMapping
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(faseDeEnsinoService.findById(id));
    }
}
