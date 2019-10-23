package com.luancomputacao.mr_xavier_backend.controllers.api.v1;

import com.luancomputacao.mr_xavier_backend.domain.Grade;
import com.luancomputacao.mr_xavier_backend.domain.dto.GradeDto;
import com.luancomputacao.mr_xavier_backend.services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/grade")
public class GradeRestController {

    @Autowired
    GradeService gradeService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(gradeService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(gradeService.findById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody Grade grade) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(grade.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
