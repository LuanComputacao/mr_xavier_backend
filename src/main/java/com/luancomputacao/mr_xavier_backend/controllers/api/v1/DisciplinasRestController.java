package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisciplinasRestController {

    @GetMapping("/professor")
    public ResponseEntity list() {
        return ResponseEntity.ok("lista de profs");
    }
}
