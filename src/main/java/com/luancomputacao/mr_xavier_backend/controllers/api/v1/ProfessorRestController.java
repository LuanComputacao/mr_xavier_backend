package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.Professor;
import com.luancomputacao.mr_xavier_backend.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/professor")
public class ProfessorRestController {

    @Autowired
    ProfessorService professorService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(professorService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(professorService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> insert(@RequestBody Professor obj) {
        obj = professorService.insert(obj);
        return getResponseEntity(obj);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody Professor obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
